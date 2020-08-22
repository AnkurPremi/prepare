package strings;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        numDecodings(s);
    }

    public static int numDecodings1(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[] dp = new int[s.length() + 1];
        char[] arr = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int val = Integer.valueOf((arr[i - 1] - '0') + "" + (arr[i] - '0'));
            if (val > 26) {
                dp[i] = 1 + dp[i - 1];
            } else {
                dp[i] = 1 + dp[i - 1] + 1;
            }
        }
        int len = dp.length;
        return dp[len];
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
