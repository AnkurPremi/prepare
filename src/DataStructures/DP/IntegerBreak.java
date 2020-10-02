package DataStructures.DP;

import java.util.ArrayList;
import java.util.List;

public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        if (n < 2) return 0;
        return integerBreak(n, dp, 1, new int[]{1}, new ArrayList<>());
    }

    public int integerBreak(int sum,  int[] dp, int product, int[] max, List<Integer> list) {
//        System.out.println(list);
        if (sum == 0) {
//            System.out.println("product-->" + product);
            max[0] = Math.max(max[0], product);
            System.out.println(list);
            System.out.println("max-->" + max[0]);
            System.out.println("--------------------");
            return product;
        }

        for (int i = 1; i <= sum; i++) {
            list.add(i);
            dp[sum] = integerBreak(sum - i, dp, product * i, max, list);
            list.remove(list.size()-1);
        }
        return dp[sum];
    }
}
