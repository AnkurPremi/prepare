package misc;

import Trees.TreeNode;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber-ii/
//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] nums1 = {2, 7, 9, 3, 1};
//        System.out.println(robHelper(nums, nums.length-1));
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
//        System.out.println(robHelperMemo(nums, memo, nums.length-1));
//        System.out.println(robHelperMemoIterative(nums));
        System.out.println(rob2(nums));
        System.out.println(rob2(nums1));

//        int[] nums1 = {2};
//        int[] nums2 = {2, 7};
//        System.out.println(rob(nums1));
//        System.out.println(rob(nums2));
//        int[] numsRob2 = {2, 1, 1, 2};
//        int[] numsRob2_1 = {1, 2, 3, 1};
//        int[] numsRob2_2 = {2, 7, 9, 3, 1};
//        System.out.println(rob2(numsRob2));
//        System.out.println(rob2(numsRob2_1));
//        System.out.println(rob2(numsRob2_2));
    }

//    public static int rob(int[] nums) {
//        if (nums == null || nums.length == 0) return -1;
//        int[] runningSumArr = new int[nums.length + 2];
//        int len = runningSumArr.length;
//        for (int i = 2; i < runningSumArr.length; i++) {
//            runningSumArr[i] = runningSumArr[i - 2] + nums[i - 2];
//        }
//        return Math.max(runningSumArr[len - 1], runningSumArr[len - 2]);
//    }

    static int robHelper(int[] nums, int i){
        if (i < 0) return 0;
        return Math.max(robHelper(nums, i - 2) + nums[i], robHelper(nums, i - 1));
    }

    static int robHelperMemo(int[] nums, int[] memo, int i) {
        if (i < 0) return 0;
        if (memo[i] >= 0) return memo[i];
        else {
            memo[i] = Math.max(robHelperMemo(nums, memo, i - 2) + nums[i], robHelperMemo(nums, memo, i - 1));
        }
        return memo[i];
    }

    static int robHelperMemoIterative(int[] nums) {
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            memo[i + 1] = Math.max(memo[i - 1] + nums[i], memo[i]);
        }
        return memo[memo.length - 1];

    }
//
//    public static int rob1(int[] nums) {
//        int len = nums.length;
//        if (len == 0) return 0;
//        else if (len == 1) return nums[0];
//        else if (len > 2) {
//            nums[2] += nums[0];
//            for (int i = 3; i < nums.length; i++) {
//                nums[i] += Math.max(nums[i - 2], nums[i - 3]);
//            }
//        }
//        return Math.max(nums[len - 1], nums[len - 2]);
//    }

    /**
     * Two values are taken prev1 and prev2.. which are imaginary numbers with initial value 0
     * these numbers are appended to the current array -- prev1 is robValue at i-1  &  prev2 is robValue at i-2
     * robValue at current house is max of (currentHouseValue + robValue at i-2(prev2) , robValue at i-1(prev1))
     * @param nums
     * @return
     */
    //house are in circle.. can't choose last and first together
    public static int rob2(int[] nums) {
        //choose first leave last..reduce length by 1
        int a = robHelperMemoIterative_rob2(nums, 0, nums.length-1);

        //choose last leave first..change start point to 1
        int b = robHelperMemoIterative_rob2(nums, 1, nums.length);

        return Math.max(a, b);
    }

    static int robHelperMemoIterative_rob2(int[] nums, int i, int len) {
        if (nums.length == 0) return 0;
        int prev1 = 0, prev2 = 0, temp = 0;
        for (int j = i; j < len; j++) {
            temp = prev1;
            prev1 = Math.max(nums[j] + prev2, prev1);
            prev2 = temp;
        }
        return prev1;
    }

    //////////////////////////////////////////////////////////////////////////////////////


}

