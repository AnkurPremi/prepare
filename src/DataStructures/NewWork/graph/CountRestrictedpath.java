package DataStructures.NewWork.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CountRestrictedpath {
    public static void main(String[] args) {
        int[][] edges = {{1,2,3},
                {1,3,3},
                {2,3,1},
                {1,4,2},
                {5,2,2},
                {3,5,1},
                {5,4,10}};
        System.out.println(new CountRestrictedpath().countRestrictedPaths(5, edges));
    }

    int mod = (int) 1e9 + 7;

    public int countRestrictedPaths(int n, int[][] edges) {

        List<Node>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            int p = edge[0], q = edge[1], val = edge[2];
            graph[p].add(new Node(val, q));
            graph[q].add(new Node(val, p));
        }

        int shortestPath = bfs(graph, 1, n);

        return dfs(graph, 1, n, 0, 0, shortestPath);

    }

    private int bfs(List<Node>[] graph, int start, int end) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        boolean[] visited = new boolean[end + 1];

        queue.offer(new int[]{start, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                int[] cur = queue.poll();
                int i = cur[0], val = cur[1];
                if(i == end) return val;
                for (Node node : graph[i]) {
                    if(node.y == i) continue;
                    visited[node.y] = true;
                    queue.offer(new int[]{node.y, val + node.val});
                }
            }
        }
        return -1;
    }

    private int dfs(List<Node>[] graph, int start, int end, int parent, int val, int shortest) {
        if (start == end) return 1;

        int ans = 0;
        for (Node node : graph[start]) {
            if (val + node.val > shortest || node.y == parent) continue;
            ans += dfs(graph, node.y, end, start, node.val, shortest);
        }

        return ans;
    }

    class Node {
        int val, y;

        Node(int val, int y) {
            this.val = val;
            this.y = y;
        }
    }
}
