package DataStructures.NewWork.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTimeCollectApples {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple = new ArrayList<>(Arrays.asList(false,false,true,false,true,true,false));
        System.out.println(new MinTimeCollectApples().minTime(7, edges, hasApple));
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //4:39
        int[] p = new int[n];
        Arrays.fill(p, -1);
        p[0] = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (p[u] == -1) {
                p[u] = v;
            } else {
                p[v] = u;
            }
        }

        boolean[] seen = new boolean[n];
        seen[0] = true;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) {
                for (int j = i; !seen[j]; j = p[j]) {
                    seen[j] = true;
                    cnt++;
                }
            }
        }
        return cnt * 2;
    }
}
