package DataStructures.problemsArray;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, 3, -3, 10};
        new SubArraySum().check(arr, 10);
    }

    public void check(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == k) System.out.println("found at index i="+i);
            prefixSum += nums[i];
            if(map.containsKey(k - prefixSum)){
                int idx = map.get(k-prefixSum);
                System.out.println("sum 0 will be found b/w: From l=" + (idx+1) + " to r="+i);
            }
            map.put(-prefixSum, i);
        }
    }

}
