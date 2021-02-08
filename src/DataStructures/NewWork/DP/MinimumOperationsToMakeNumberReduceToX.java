package DataStructures.NewWork.DP;

public class MinimumOperationsToMakeNumberReduceToX {
    public static void main(String[] args) {
        int[] nums  = {3,2,20,1,1,3};
        int x = 10;
        System.out.println(new MinimumOperationsToMakeNumberReduceToX().minOperations(nums, x));
    }

    public int minOperations(int[] nums, int x) {

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int sumHere = 0;
        int start = 0, end = 0;
        while(end < n){
            sumHere += nums[end];
            while(sum - sumHere <= x){
                if(sum - sumHere == x){
                    ans = Math.min(ans, n - (end - start + 1));
                }
                sumHere -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
