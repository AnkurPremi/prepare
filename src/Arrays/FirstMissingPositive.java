package Arrays;

import java.util.Arrays;

//https://leetcode.com/problems/first-missing-positive/
//If we know that the range of numbers in an array is [1, arr.length] .. then use the technique of marking the
// numbers negative in the array on the basis of the index
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(new FirstMissingPositive().firstMissingPositive2(nums));
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
        if (found) return nums[nums.length - 1] + 1;
        return 1;
    }

    public int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        Arrays.sort(nums);
        if (nums[0] > 1 || nums[nums.length - 1] <= 0) return 1;
        int start = 0;
        while (nums[start] <= 0) start++;
        if (nums[start] > 1) return 1;
        for (int i = 1; start < nums.length && i <= nums[nums.length - 1]; i++) {
            if (nums[start] != i) return i;
            start++;
        }
        return nums[nums.length - 1] + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;
        //since we are searching for first positive number, all the numbers in the array should be in the range of [1, n+1]
        //Convert all the numbers in the array which are either less than equal to 0 or greater than equal to n
        //change the numbers to n+1.. this will change all the negative numbers and big numbers to be in the range [1, n+1]
        //O(n)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        //since we know that the numbers in the array are in the range [1, n+1]
        //we can use the technique of using the numbers as indices and marking the numbers as the negative using the indices
        //O(n)
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            num--; //to make it as 0 based index
            if (num >= n) continue;
            if (nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }
        }

        //Now find out the first index where the integer is positive.
        //return index+1 as the answer
        //O(n)
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return n + 1;
    }
}
