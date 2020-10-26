package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.List;

public class InsertNewInterval {
    public static void main(String[] args) {
        int[][] intervals = {{3,5},{6,7},{8,10},{12,16}};
        intervals = new InsertNewInterval().insert(intervals, new int[]{16,17});
        System.out.println("adsda");
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) return intervals;
        if (intervals.length == 0) return new int[][]{newInterval};

        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        int i=0;
        while(i < intervals.length && intervals[i][1] < start) {
            res.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && intervals[i][0] <= end){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{start, end});
        while(i < intervals.length)
            res.add(intervals[i++]);

        return res.toArray(new int[0][]);
    }
}
