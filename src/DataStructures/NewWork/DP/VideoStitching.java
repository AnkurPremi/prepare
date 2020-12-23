package DataStructures.NewWork.DP;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {
    public static void main(String[] args) {

    }

    public int videoStitching(int[][] clips, int T) {
        int res = 0;
        Arrays.sort(clips, (a, b) ->{
           return a[0] - b[0];
        });
        int start = 0, end = 0;
        for (int i = 0 ; start < T; ++res) {
            for (; i < clips.length && clips[i][0] <= start; ++i)
                end = Math.max(end, clips[i][1]);
            if (start == end) return -1;
            start = end;
        }
        return res;
    }
}
