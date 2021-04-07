package DataStructures.NewWork.graph;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {
    public static void main(String[] args) {
        int ans = 3 ^ 4 ^ 7;
        System.out.println(ans);
        int[][] grid = {{1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}};
//        System.out.println(new BestMeetingPoint().minTotalDistance(grid));
    }

    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        List<Integer> I = new ArrayList<Integer>();
        List<Integer> J = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    J.add(j);
                }
            }
        }
        return minTotalDistance(I) + minTotalDistance(J);
    }

    public int minTotalDistance(List<Integer> grid) {
        int i = 0, j = grid.size() - 1, sum = 0;
        while (i < j) {
            sum += grid.get(j) - grid.get(i);
            i++;
            j--;
        }
        return sum;
    }
}
