package DataStructures.NewWork.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeGraphDiameter {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{1,4},{4,5}};
        System.out.println(new TreeGraphDiameter().treeDiameter(edges));
    }

    public int treeDiameter(int[][] edges) {
        int ans = 0;
        int n = edges.length;
        int[] dist = new int[n + 1];
        for(int i=0 ; i<n ; i++){
            int u = edges[i][0], v = edges[i][1];
            ans = Math.max(ans, dist[u] + dist[v] + 1);

            dist[u] = Math.max(dist[u] , dist[v] + 1);
            dist[v] = Math.max(dist[v] , dist[u] + 1);
        }
        return ans;
    }


    int diameter = 0;
    public int treeDiameter1(int[][] edges) {
        int n = edges.length;
        List<Integer>[] nodes = new List[n+1];
        for(int i=0; i<=n ; i++)
            nodes[i] = new ArrayList<>();

        for(int[] edge : edges){
            nodes[edge[0]].add(edge[1]);
            nodes[edge[1]].add(edge[0]);
        }
        dfs(nodes, 0, -1);
        return diameter;
    }

    private int dfs(List<Integer>[] nodes, int root, int parent){
        int maxD1 = 0, maxD2 = 0;

        for(int node : nodes[root]){
            if(node == parent) continue;

            int depth = dfs(nodes, node, root);

            if(depth > maxD1){
                maxD2 = maxD1;
                maxD1 = depth;
            } else if(depth > maxD2){
                maxD2 = depth;
            }
        }

        int maxD = maxD1 + maxD2;
        diameter = Math.max(maxD, diameter);

        return Math.max(maxD1, maxD2) + 1;
    }
}
