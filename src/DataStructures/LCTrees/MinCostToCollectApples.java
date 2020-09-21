package DataStructures.LCTrees;

import java.util.*;

public class MinCostToCollectApples {
    public static void main(String[] args) {
        int[][] edges = {
                {0,1},{0,2},{1,4},{1,5},{2,3},{2,6}
        };
        List<Boolean> hasApple = new ArrayList<>(Arrays.asList(false,false,true,false,true,true,false));
        System.out.println(new MinCostToCollectApples().minTime(7, edges, hasApple));
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] arr: edges){
            graph.computeIfAbsent(arr[0], num -> new ArrayList()).add(arr[1]);
            graph.computeIfAbsent(arr[1], num -> new ArrayList()).add(arr[0]);
        }
        return calcCost(0, graph, new boolean[n], hasApple, 0);
    }

    public int calcCost(int node, Map<Integer, ArrayList<Integer>> graph, boolean[] visited, List<Boolean> hasApple, int mycost){
        if(visited[node]) return 0;
        visited[node] = true;

        int childCost = 0;
        for(int n : graph.get(node)){
            childCost += calcCost(n, graph, visited, hasApple, 2);
        }
        if(childCost == 0 && !hasApple.get(node)){
            return 0;
        }
        return childCost + mycost;
    }
}
