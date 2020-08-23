package Arrays;

import strings.EditDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18},
        };
//        EditDistance.printMatrix(new MergeIntervals().merge(intervals));

        int[][] intervals1 = {
                {1, 4},
                {0, 2},
                {3, 5}
        };
        EditDistance.printMatrix(new MergeIntervals().merge(intervals1));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] arr : intervals) {
            list.add(arr);
        }
        int i = 0, j = 1;
        while (i < list.size() && j < list.size()) {
            boolean canBeMerged = checkCanBeMerged(list.get(i), list.get(j));
            if (canBeMerged) {
                list.get(i)[0] = Math.min(list.get(i)[0], list.get(j)[0]);
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
        return (arr2[0] >= arr1[0] && arr2[0] <= arr1[1])
                || (arr2[1] >= arr1[0] && arr2[1] <= arr1[1])
                || (arr2[0] < arr1[0] && arr2[1] >= arr1[1]);
    }
}
