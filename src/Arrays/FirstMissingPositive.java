package Arrays;

import java.util.Arrays;

//https://leetcode.com/problems/first-missing-positive/
//If we know that the range of numbers in an array is
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(new FirstMissingPositive().firstMissingPositive1(nums));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        if (nums[0] > 1 || nums[nums.length - 1] <= 0) return 1;
        int start1 = 0;
        while (nums[start1] <= 0) start1++;
        if (nums[start1] > 1) return 1;
        boolean found = false;
        for (int i = 1; i <= nums.length; i++) {
            int end = nums.length - 1;
            int start = start1;
            found = false;
            while (start <= end) {
                int mid = (start + end) >> 1;
                if (nums[mid] == i) {
                    found = true;
                    break;
                } else if (nums[mid] > i) {
                    end--;
                } else {
                    start++;
                }
            }
            if (!found) return i;
        }
        if(found) return nums[nums.length-1]+1;
        return 1;
    }

    public int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        Arrays.sort(nums);
        if (nums[0] > 1 || nums[nums.length - 1] <= 0) return 1;
        int start = 0;
        while (nums[start] <= 0) start++;
        if (nums[start] > 1) return 1;
        for(int i=1; start< nums.length && i<= nums[nums.length-1] ; i++){
            if(nums[start] != i)return i;
            start++;
        }
        return nums[nums.length-1]+1;
    }
}
