package DataStructures.Hackerrank.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/non-divisible-subset/problem
public class Non_Div_subset {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(19,10,12,10,24,25,22));
        System.out.println(Non_Div_subset.nonDivisibleSubset(3, list));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int n = s.size();
        if (n == 0 || k == 1) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((s.get(j) + s.get(i)) % k != 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max == 1 ? 0 : max;
    }
}
