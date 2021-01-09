package DataStructures.NewWork.Tree;

import java.util.Arrays;

public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
        int[] edge = new RedundantConnection().findRedundantConnection(edges);
        System.out.println("asdasd");
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        Arrays.fill(parent, -1);
        int[] ans = {-1, -1};
        for (int[] edge : edges) {

            int parent1 = findParent(parent, edge[0]);
            int parent2 = findParent(parent, edge[1]);
            if (parent1 == parent2) return edge;
            union(parent, edge[0], edge[1]);
        }
        return ans;
    }

    public void union(int parent[], int x, int y) {
        int xset = findParent(parent, x);
        int yset = findParent(parent, y);
        parent[xset] = yset;
    }


    private int findParent(int[] parent, int f) {
        if (parent[f] == -1) return f;
        return findParent(parent, parent[f]);

    }
}
