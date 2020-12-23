package DataStructures.NewWork.Tree;

import java.util.Arrays;

public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1,4},{3,4},{1,3},{1,2},{4,5}};
        int[] edge = new RedundantConnection().findRedundantConnection(edges);
        System.out.println("asdasd");
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] set = new int[edges.length+1];
        Arrays.fill(set, -1);
        int[] ans = {-1,-1};
        for(int[] edge : edges){
            if(set[edge[0]] == -1 && set[edge[1]] == -1){
                set[edge[1]] = edge[0];
            }
            else{
                int parent1 = edge[0];
                while(set[parent1] != -1){
                    parent1 = set[parent1];
                }

                int parent2 = edge[1];
                while(set[parent2] != -1){
                    parent2 = set[parent2];
                }

                if(parent1 == parent2){
                    ans = edge;
                    return edge;
                }

                set[edge[0]] = parent1;
                set[edge[1]] = parent1;
            }
        }
        return ans;
    }
}
