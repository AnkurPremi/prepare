package DataStructures.NewWork.Tree;

import java.util.Arrays;

public class UniqueBSTCount {
    public static void main(String[] args) {
        System.out.println(new UniqueBSTCount().numTrees(3));
    }

    public int numTrees(int n) {
        int[] map = new int[n+1];
        map[0] = 1;
        map[1] = 1;
        return helper(n, map);
    }

    public int helper(int n, int[] map) {

        for (int i=2; i<=n; i++) {
            for(int j=1 ; j<=i ; j++)
                map[i] += map[j-1] * map[i-j];
        }
        return map[n];
    }
}
