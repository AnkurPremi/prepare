package DataStructures.problemsArray;

import java.util.HashMap;
import java.util.Map;

public class NonOverlapping3SubArraysSumMax {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        int[] result = new NonOverlapping3SubArraysSumMax().maxSumOfThreeSubarrays(nums, k);
        System.out.println("dasdad");
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;
        //this map will store the index and the sum of k integers subArray starting from that index
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sumHere = 0;
        for (int i = 0; i < k; i++) {
            sumHere += nums[i];
        }
        map.put(0, sumHere);
        int start = 1, end = k;
        while (end < n) {
            sumHere += nums[end] - nums[start - 1];
            map.put(start, sumHere);
            end++;
            start++;
        }

        int l = 0, m = k, r = m + k;
        int maxSum = 0;
        int[] result = new int[3];
        for (int i = 0; i < n - 2 * k; i += k, m += k, r += k) {
            int sum = map.get(i) + map.get(m) + map.get(r);
            if (maxSum < sum) {
                result[0] = i;
                result[1] = m;
                result[2] = r;
                maxSum = sum;
            }
        }
        return result;
    }
}

