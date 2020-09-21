package DataStructures.SortingAndSeraching;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicate1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(arr, k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< nums.length; i++){
            //In order to maintain the requirement, we will check for the duplicate in range only (within k)
            //If we are going beyond range, remove the element from the set
            if(i > k){
                set.remove(nums[i-k-1]);
            }

            //If all the elements get added to the set that means there are no duplicates
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
