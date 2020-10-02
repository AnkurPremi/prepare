package DataStructures.HashTable;

import java.util.HashMap;
import java.util.Map;

public class GoodPairs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 3};
        System.out.println(new GoodPairs().numIdenticalPairs(arr));
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans += getFactorial(entry.getValue() - 1)+1;
        }
        return ans;
    }

    public int getFactorial(int n) {
        if (n == 0) return 0;
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * i;
        }
        return ans;
    }
}
