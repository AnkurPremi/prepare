package DataStructures.NewWork.LCStrings;

public class RegexMatch {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b*";
        System.out.println(new RegexMatch().isMatch1(s, p));
    }

    Boolean[][] dp;
    public boolean isMatch1(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        return helper(0, 0, s, p);
    }

    private boolean helper(int i, int j, String s, String p) {
        if(dp[i][j] != null) return dp[i][j];
        boolean res;
        if(j == p.length()) {
            res = i == s.length();
        } else {
            boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if(j <= p.length() -2 && p.charAt(j+1) == '*') {
                boolean discard = helper(i, j+2, s, p);
                boolean repeat = firstMatch && helper(i+1, j, s, p);
                res =  discard || repeat;
            } else {
                res =  firstMatch && helper(i+1, j+1, s, p);
            }
        }
        dp[i][j] = res;
        return res;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true; //empty string and empty pattern

        //to check the empty string match with pattern
        //only #*#*#*   (where # is any char) - can match because.. every #* can represent empty string

        for (int i = 2; i <= m; i += 2) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        //ab - c*ab
        //ab - a*b
        //aa - a*
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; //excluding this what's the answer
                } else if (p.charAt(j - 1) == '*') {
                    char prev = p.charAt(j - 2);
                    if (prev != '.' && prev != s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j - 2]; //considering #* pattern as empty... taking whatever was answer -->>> with the present char of s and 2 characters back of p
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
