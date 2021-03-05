package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;

public class GetTheMaxScore {
    public static void main(String[] args) {
        int[] nums1 = {2,4,5,8,10};
        int[] nums2 = {4,6,8,9};
        System.out.println(new GetTheMaxScore().maxSum(nums1, nums2));
    }

    int mod = (int) 1e9 + 7;
    Map<Integer, Integer> map1;
    Map<Integer, Integer> map2;

    public int maxSum(int[] nums1, int[] nums2) {
        map1 = new HashMap();
        map2 = new HashMap();
        for (int i = 0; i < nums1.length; i++) map1.put(nums1[i], i);
        for (int i = 0; i < nums2.length; i++) map2.put(nums2[i], i);

        return solve(nums1, nums2, 0, 0, true);
    }

    private int solve(int[] nums1, int[] nums2, int i, int j, boolean first) {
        if (i == nums1.length) return sumRemaining(nums2, j);
        if (j == nums2.length) return sumRemaining(nums1, i);

        int ans = 0;

        if (first) {
            int v1 = nums1[i] + solve(nums1, nums2, i + 1, j, first);
            int v2 = 0;
            if (map2.containsKey(nums1[i])) {
                int idx = map2.get(nums1[i]);
                v2 = nums2[idx] + solve(nums1, nums2, i, idx + 1, !first);
            }
            ans = Math.max(v1, v2);
        } else {
            int v1 = nums2[j] + solve(nums1, nums2, i, j + 1, first);
            int v2 = 0;
            if (map1.containsKey(nums2[j])) {
                int idx = map1.get(nums2[j]);
                v2 = nums1[idx] + solve(nums1, nums2, idx + 1, j, !first);
            }
            ans = Math.max(v1, v2);
        }

        return ans;
    }

    private int sumRemaining(int[] nums, int j) {
        int sum = 0;
        for (int i = j; i < nums.length; i++)
            sum += nums[i];

        return sum;
    }
}
