package DataStructures.LCTrees;



import java.util.ArrayList;
import java.util.List;

public class ReOrderRoutesBT {
    public static void main(String[] args) {
        int[][] coll = {
                {0,1},{1,2},{2,3},{3,4},{4,5},{5,0}
        };
        System.out.println(new ReOrderRoutesBT().minReorder(6, coll));
    }

    int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (var to : al.get(from))
            if (!visited[Math.abs(to)])
                change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            al.add(new ArrayList<>());
        for (var c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        return dfs(al, new boolean[n], 0);
    }

}
