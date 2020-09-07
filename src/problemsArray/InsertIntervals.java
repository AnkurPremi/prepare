package problemsArray;

import strings.EditDistance;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {3,5},
                {6, 7},
                {8, 10},
                {12, 16},
        };
        int[] newInterval = {4, 8};
        EditDistance.printMatrix(new InsertIntervals().insert(intervals, newInterval));

        int[][] intervals1 = {
                {1, 5}
        };
        int[] newInterval1 = {0, 3};
        EditDistance.printMatrix(new InsertIntervals().insert(intervals1, newInterval1));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] result = new int[1][1];
            result[0] = newInterval;
            return result;
        }
        List<int[]> list = new ArrayList<>();
        boolean added = false;
        for (int i = 0; i < intervals.length; i++) {
            if(!added && intervals[i][0] > newInterval[0] ){
                list.add(newInterval);
                added = true;
            }
            list.add(intervals[i]);
            if (!added && intervals[i][0] < newInterval[0] && i + 1 < intervals.length && intervals[i + 1][0] > newInterval[0]) {
                list.add(newInterval);
                added = true;
            }
        }
        if (!added) list.add(newInterval);
        return merge(list);
    }

    public int[][] merge(List<int[]> list) {
        int i = 0, j = 1;
        while (i < list.size() && j < list.size()) {
            boolean canBeMerged = checkCanBeMerged(list.get(i), list.get(j));
            if (canBeMerged) {
//                list.get(i)[0] = Math.min(list.get(i)[0], list.get(j)[0]);
                list.get(i)[1] = Math.max(list.get(i)[1], list.get(j)[1]);
                list.remove(j);
            } else {
                i++;
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    private boolean checkCanBeMerged(int[] arr1, int[] arr2) {
        return (arr2[0] >= arr1[0] && arr2[0] <= arr1[1]);
//                || (arr2[1] >= arr1[0] && arr2[1] <= arr1[1])
//                || (arr2[0] < arr1[0] && arr2[1] >= arr1[1]);
    }
}
