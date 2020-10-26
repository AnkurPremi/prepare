package DataStructures.NewWork.LCArray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinDiffBWMaxMinAfter3Change {
    public static void main(String[] args) {
        int[] arr = {1,3,5,8,1,0,6,6,12,13,14,15,16,22};
        System.out.println(new MinDiffBWMaxMinAfter3Change().minDifference(arr));
    }

    public int minDifference(int[] nums) {
        if (nums.length < 5) return 0;
        if (nums.length <= 8) return getDiff(nums, true);
        PriorityQueue<Integer> top4 = new PriorityQueue<>(), bot4 = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) {
            top4.offer(n);
            bot4.offer(n);
            if (top4.size() > 4) top4.poll();
            if (bot4.size() > 4) bot4.poll();
        }
        int[] arr = new int[8];
        for (int l = 3, r = 4; l >= 0 && r < 8; l--, r++) {
            arr[l] = bot4.poll();
            arr[r] = top4.poll();
        }
        return getDiff(arr, false);
    }

    private int getDiff(int[] arr, boolean needSort) {
        if (needSort) Arrays.sort(arr);
        int res = Integer.MAX_VALUE, n = arr.length;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, arr[n - (4 - i)] - arr[i]);
        }
        return res;
    }
}
