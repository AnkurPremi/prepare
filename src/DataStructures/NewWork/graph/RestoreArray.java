package DataStructures.NewWork.graph;

import java.util.*;

public class RestoreArray {
    public static void main(String[] args) {

        int[][] pairs = {{2, 1},
                {3, 4},
                {3, 2}};
        int[] ans = new RestoreArray().restoreArray(pairs);
        System.out.println("Asdasd");
    }

    int idx = 0;
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        Map<Integer, List<Integer>> graph = prepareGraph(adjacentPairs);
        Set<Integer> visited = new HashSet();

        Integer source = null;

        for(int key : graph.keySet()){
           if(graph.get(key).size() == 1 && source == null){
               source = key;
               break;
           }
        }

        int[] ans = new int[n + 1];
        idx = n;
        dfs(graph, source, -1, visited, ans);
        return ans;
    }


    private void dfs(Map<Integer, List<Integer>> graph, int node, int parent, Set<Integer> visited, int[] ans) {
        if(visited.contains(node)) return;

        ans[idx--] = node;

        visited.add(node);

        for (int v : graph.get(node)) {
            if (v == parent) continue;
            dfs(graph, v, node, visited, ans);
        }

    }

    private Map<Integer, List<Integer>> prepareGraph(int[][] adjacentPairs) {

        Map<Integer, List<Integer>> graph = new HashMap();
        for (int[] pair : adjacentPairs) {
            int u = pair[0];
            int v = pair[1];

            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList());
            }

            if (!graph.containsKey(v)) {
                graph.put(v, new ArrayList());
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
