package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;

public class GetSpecialOnesGrid {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(new GetSpecialOnesGrid().numSpecial(grid));
    }

    public int numSpecial(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] rMap = new int[n];
        int[] cMap = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    rMap[i]++;
                    cMap[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && rMap[i] == 1 && cMap[j] == 1)
                    count++;
            }
        }
        return count;
    }

}
