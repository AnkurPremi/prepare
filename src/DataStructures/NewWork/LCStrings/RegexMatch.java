package DataStructures.NewWork.LCStrings;

public class RegexMatch {
    public static void main(String[] args) {
        String s = "abcdef";
        String p = "a*************************b*cdef";
        System.out.println(new RegexMatch().isMatch(s, p));
    }

    public boolean isMatch(String s, String p){
        return helper(s, p, 0, 0);
    }

    public boolean helper(String s, String p, int idx1, int idx2){

        char[] pattern = p.toCharArray();
         char[] str = s.toCharArray();

          int writer = 0;
          boolean first = true;
          for(int i=0 ; i<pattern.length ; i++){
              if(pattern[i] == '*'){
                  if(first){
                      pattern[writer++] = pattern[i];
                      first = false;
                  }
              }
              else{
                  pattern[writer++] = pattern[i];
                  first = true;
              }
          }
        if(idx1 < 0 || idx2 < 0) return false;
        if(idx1 == s.length() && idx2 == p.length())
            return true;

        if(idx1 == s.length())
            return false;
        if(idx2 == p.length())
            return false;

        if(p.charAt(idx2) == '.' || s.charAt(idx1) == p.charAt(idx2)){
            return helper(s, p, idx1 + 1, idx2 + 1);
        }
        else if(idx2 +1 < p.length() && p.charAt(idx2+1) == '*'){
            if(helper(s, p, idx1, idx2+2))
                return true;
//            if(p.charAt(idx2) == '.' || s.charAt(idx1) == p.charAt(idx2+1))
        }

        else if(p.charAt(idx2) == '*'){
            return helper(s, p, idx1, idx2-1) || helper(s, p, idx1, idx2+1);
        }

        return false;
    }

    public boolean isMatch1(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp[0].length; i++) {
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == str[i - 1]) {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                }
            }
        }

        return dp[str.length][pattern.length];
    }
}
