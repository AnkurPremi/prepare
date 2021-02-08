package DataStructures.NewWork.LCArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinOperationsToMakeSubSequence_1713 {
    public static void main(String[] args) {
        int[] target = {5,1,3};
        int[] arr = {9,4,2,3,4};
        System.out.println(new MinOperationsToMakeSubSequence_1713().minOperations(target, arr));
    }

    public int minOperations(int[] target, int[] arr) {
        int idx = 0;
        Map<Integer, Integer> map = new HashMap();

        for (int num : target) {
            map.put(num, idx++);
        }

        int[] nums = new int[arr.length];
        int writer = 0;
        for (int num : arr) {
            if (!map.containsKey(num)) continue;
            nums[writer++] = map.get(num);
        }

        //Do LIS on list;
        int[] dp = new int[writer];
        int len = 0;
        for (int i = 0; i < writer; i++) {
            int p = Arrays.binarySearch(dp, 0, len, nums[i]);
            if (p < 0) p = -(p + 1);
            dp[p] = nums[i];
            if (p == len) len++;
        }

        return target.length - len;
    }
}
