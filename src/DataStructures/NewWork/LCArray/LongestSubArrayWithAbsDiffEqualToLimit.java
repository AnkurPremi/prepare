package DataStructures.NewWork.LCArray;

import java.util.Deque;
import java.util.LinkedList;

public class LongestSubArrayWithAbsDiffEqualToLimit {
    public static void main(String[] args) {
        int[] arr = {4,2,2,2,4,4,2,2};
        System.out.println(new LongestSubArrayWithAbsDiffEqualToLimit().longestSubarray(arr, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int res = 1;

        int l = 0;

// find the longest subarray for every right pointer by shrinking left pointer
        for (int r = 0; r < nums.length; ++r) {

            // update maxDeque with new right pointer
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[r]);

            // update minDeque with new right pointer
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
                minDeque.removeLast();
            }
            minDeque.addLast(nums[r]);

            // shrink left pointer if exceed limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[l]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[l]) minDeque.pollFirst();
                ++l;  // shrink it!
            }

            // update res
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public int longestSubarray1(int[] nums, int limit) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int maxLen = 0;
        for(int i=0; i<nums.length-1; i++){
            int j = i+1, len = 1;
            min = nums[i]; max = nums[i];
            while(j < nums.length){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                if(max - min > limit){
                    maxLen = Math.max(maxLen, len);
                    break;
                } else{
                    len++;
                }
                j++;
            }
            if(j == nums.length) return Math.max(maxLen, len);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

}
