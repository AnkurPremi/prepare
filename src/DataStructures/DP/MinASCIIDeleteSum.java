package DataStructures.DP;

public class MinASCIIDeleteSum {
    public static void main(String[] args) {
        String a = "sea";
        String b = "eat";
        System.out.println(new MinASCIIDeleteSum().minSum(a, b));
    }

    public int minSum(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        //base case
        //when we have String a = "" and b = <some_string>
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + b.charAt(i - 1);
        }

        //when we have String a = <some_string> and b = ""
        for (int j = 1; j <= m; j++) {
            dp[j][0] = dp[j - 1][0] + a.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                //case 1 - when both the characters are same
                //answer will be whatever we previously had
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                //case 2 - when characters are diff
                //find minimum of two conditions
                    //1st - delete char of string 'a' and add tha to the sum
                    //2nd - delete char of string 'b' and add tha to the sum
                else {
                    dp[i][j] = Math.min(dp[i - 1][j] + a.charAt(i - 1), dp[i][j - 1] + b.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }

}
