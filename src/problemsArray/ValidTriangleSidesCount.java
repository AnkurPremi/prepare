package problemsArray;

import java.util.Arrays;

//https://leetcode.com/problems/valid-triangle-number/
//sum of two sides always greater than 3rd side
public class ValidTriangleSidesCount {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 4, 5, 6};
    }

    //we can improve upon more.. by using 3 pointers in sorted array
    //O(N^2) ~ ( O(N^2) + O(NlogN) )
    public int getCount(int[] nums) {
        int result = 0;
        int len = nums.length;
        if (len < 3) return result;
        Arrays.sort(nums);
        for (int i = 2; i < len; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    //if we will sort the array.. we don't have to check for all the conditions
    //a+b > c..where a<b<c ... adding anything to c will always be greater .. c+a > b  and  c+b > a
    //O(N^2logN) ... inner loop will take NlogN in worst case
    //after selecting two elements we will do binary search in right array
    //and search for first index which doesn't satisfy the triangle sides condition (a+b>c)
    //after first inner loop..value of k index cannot comeback..since we are increasing the value of j..by moving right
    //and the results before obtained will be valid for this combination as well
    //and the condition will be valid a+B > c ... here B is increased value
    public int getCount2(int[] nums) {
        int result = 0;
        int len = nums.length;
        if (len < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < len - 1; j++) {
                k = binarySearch(nums, k, len - 1, nums[i] + nums[j]);
                result += (k - j - 1); // all the numbers in this range will satisfy the triangle condition
            }
        }
        return result;
    }

    //we have to find the first index..whose value is greater or equal to target
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //Brute force option..get all the possible combinations and check
    //O(N^3)
    public int getCount3(int[] nums) {
        int result = 0;
        int len = nums.length;
        if (len < 3) return result;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i]) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

}
