package DataStructures.NewWork.DP;

import java.util.Arrays;

public class MinSumOfLength {
    public static void main(String[] args) {
        int[] arr = {4,3,2,6,2,3,4};
        System.out.println(new MinSumOfLength().minSumOfLengths(arr, 6));
    }

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int best[] = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        int sum = 0, start = 0, ans = Integer.MAX_VALUE, bestSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            while(sum > target){
                sum -= arr[start];
                start++;
            }
            if(sum == target){
                if(start > 0 && best[start - 1] != Integer.MAX_VALUE){
                    ans = Math.min(ans, best[start - 1] + i - start + 1);
                }
                bestSoFar = Math.min(bestSoFar, i - start + 1);
            }
            best[i] = bestSoFar;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
