package DataStructures.NewWork.DP;

public class WildcardMatch {
    public static void main(String[] args) {
        System.out.println(new WildcardMatch().isMatch("aa", "*"));
    }

    public boolean isMatch(String s, String p) {

        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return helperDP(s.toCharArray(), p.toCharArray(), 0, 0, dp);

    }

    public boolean helperDP(char[] s, char[] p, int idx1, int idx2, Boolean[][] dp){
        if(dp[idx1][idx2] != null) return dp[idx1][idx2];

        if(idx1 == s.length && idx2 == p.length) return true;
        if(idx1 == s.length && idx2 == p.length - 1 && p[idx2] == '*') return true;
        if(idx1 == s.length || idx2 == p.length) return false;

        dp[idx1][idx2] = false;

        if(p[idx2] == '*'){
            dp[idx1][idx2] = helperDP(s, p, idx1+1, idx2, dp) || helperDP(s, p, idx1, idx2+1, dp);
        }

        else if(p[idx2] == '?' || p[idx2] == s[idx1]){
            dp[idx1][idx2] = helperDP(s, p, idx1+1, idx2+1, dp);
        }


        return dp[idx1][idx2];
    }
}
