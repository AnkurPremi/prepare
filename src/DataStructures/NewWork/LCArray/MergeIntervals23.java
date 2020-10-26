package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals23 {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {2, 3}};
        new MergeIntervals23().merge(arr);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        if (intervals.length == 0) return intervals;
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] k = list.get(list.size() - 1);
            if (intervals[i][0] <= k[1]) {
                if (k[1] <= intervals[i][1])
                    k[1] = intervals[i][1];
            } else {
                list.add(intervals[i]);
            }
        }
        int[][] result = new int[list.size()][2];
        int j = 0;
        for (int[] i : list) {
            result[j++] = i;
        }
        return result;
    }
}
