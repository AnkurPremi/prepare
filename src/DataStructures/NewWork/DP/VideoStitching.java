package DataStructures.NewWork.DP;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {
    public static void main(String[] args) {
        int[][] clips = {{0,1},{1,2}};
        int T = 9;
        System.out.println(new VideoStitching().videoStitching(clips, T));
    }

//    public int videoStitchingSort(int[][] clips, int T) {
//        int res = 0;
//        Arrays.sort(clips, (a, b) ->{
//           return a[0] - b[0];
//        });
//        int start = 0, end = 0;
//        for (int i = 0 ; start < T; ++res) {
//            for (; i < clips.length && clips[i][0] <= start; ++i)
//                end = Math.max(end, clips[i][1]);
//            if (start == end) return -1;
//            start = end;
//        }
//        return res;
//    }


     /*
        i/p - [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]
                10
        sort - [[0,2], [1,5], [1,9], [4,6], [5,9], [8,10]]
        s=0     s=2             s=9                 s=10
        e=0     e=2             e=9                 e=10

        result = 3

    */

    public int videoStitching(int[][] clips, int T) {
        if (clips == null || T == 0 || clips.length == 0) {
            return 0;
        }
        final int[] steps = new int[T + 1];
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] >= 0) {
                int left = clips[i][0];
                if(left > T) continue;
                steps[left] = Math.max(steps[left], clips[i][1]);
            }
        }
        int previousMaxReachableDistance = 0, maxReachableDistance = 0, count = 0, position = 0;
        while (position < steps.length && previousMaxReachableDistance < T) {
            count++;
            // we try to jump as far as possible by iterating all steps from current position to the previous maxReachableDistance
            while (position < steps.length && position <= previousMaxReachableDistance) {
                maxReachableDistance = Math.max(maxReachableDistance, steps[position++]);
            }
            // means that we didn't find anything to progress - we stay on the same position; that means we don't have a solution
            if (previousMaxReachableDistance == maxReachableDistance) {
                return -1;
            }
            previousMaxReachableDistance = maxReachableDistance;
        }
        return maxReachableDistance>=T ? count : -1;
    }
}
