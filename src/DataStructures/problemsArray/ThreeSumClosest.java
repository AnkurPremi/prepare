package DataStructures.problemsArray;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        new ThreeSumClosest().threeSumClosest(nums, 1);
    }

    public int threeSumClosest(int[] nums, int k) {
        int len = nums.length;
        if (len < 3) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 2; i < len; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int sumHere = nums[l] + nums[r] + nums[i];
                if (sumHere == k) {
                    return sumHere;
                }
                //if sum is less I can move towards the target
                else if (sumHere < k) {
                    if (Math.abs(k - sumHere) < min) {
                        min = Math.abs(k - sumHere);
                        sum = sumHere;
                    }
                    l++;
                }
                //if sum is greater, I can come back towards the target
                else {
                    if (Math.abs(sumHere - k) < min) {
                        min = Math.abs(sumHere - k);
                        sum = sumHere;
                    }
                    r--;
                }
            }
        }
        return sum;

    }
}
