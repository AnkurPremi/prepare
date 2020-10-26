package DataStructures.NewWork.LCArray;

public class LongestSubArrayWithAbsDiffEqualToLimit {
    public static void main(String[] args) {
        int[] arr = {4,2,2,2,4,4,2,2};
        System.out.println(new LongestSubArrayWithAbsDiffEqualToLimit().longestSubarray(arr, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
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
