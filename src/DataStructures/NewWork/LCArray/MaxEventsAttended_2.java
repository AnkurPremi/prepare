package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class MaxEventsAttended_2 {
    public static void main(String[] args) {
        int[][] events = {{1,2,4},
                {3,4,3},
                {2,3,10}};
        System.out.println(new MaxEventsAttended_2().maxValue(events, 2));
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) ->
                a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        Integer[][] cache = new Integer[events.length + 1][k + 1];

        return helper(events, k, 0, -1, cache, 0);
    }

    private int helper(int[][] events, int k, int idx, int preidx, Integer[][] cache, int prevEnd) {

        if (idx >= events.length || k == 0) return 0;

        if (preidx >= 0 && cache[preidx][k] != null)
            return cache[preidx][k];

        int max = helper(events, k, idx + 1, preidx, cache, prevEnd);

        if (events[idx][0] > prevEnd)
            max = Math.max(max,helper(events, k - 1, idx + 1, idx, cache, events[idx][1]) + events[idx][2]);

        if(preidx >= 0)
            cache[preidx][k] = max;

        return max;
    }



//    public int maxValue(int[][] events, int k) {
//        Arrays.sort(events, (a, b) -> {
//            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
//        });
//
//        Integer[][] cache = new Integer[events.length + 1][k + 1];
//
//        return helper(events, k, 0, cache, 0);
//    }
//
//    private int helper(int[][] events, int k, int idx, Integer[][] cache, int prevEnd) {
//        if (idx >= events.length || k == 0) return 0;
//
//        if (cache[idx][k] != null) return cache[idx][k];
//
//        int max = helper(events, k, idx + 1, cache, prevEnd);
//
//        if (events[idx][0] > prevEnd) {
//            max = Math.max(max, events[idx][2] + helper(events, k - 1, idx + 1, cache, events[idx][1]));
//        }
//
//        cache[idx][k] = max;
//        return max;
//    }
    
}
