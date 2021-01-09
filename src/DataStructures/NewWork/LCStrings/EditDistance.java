package DataStructures.NewWork.LCStrings;

public class EditDistance {
    static int count = 0;

    public static void main(String[] args) {
        String s = "horse";
        String p = "ros";
        System.out.println(new EditDistance().minDistance(s, p));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i=0 ; i<=n ; i++){
            for(int j=0 ; j<=m ; j++){
                if(i == 0){
                    dp[i][j] = j;
                } else if(j == 0){
                    dp[i][j] = i;
                } else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }

//    public int minCount1(String s, String p) {
//        if (s.isEmpty()) return p.length();
//        else if (p.isEmpty()) return s.length();
//        return editDist1(s, p, s.length(), p.length());
//    }
//
//    public int editDist1(String s, String p, int m, int n) {
//        if (m == 0) return n;
//        else if (n == 0) return m;
//
//        if (s.charAt(m - 1) == p.charAt(n - 1))
//            return editDist1(s, p, m - 1, n - 1);
//
//        else {
//
//            return 1 + Math.min(editDist1(s, p, m, n - 1), Math.min(editDist1(s, p, m - 1, n), editDist1(s, p, m - 1, n - 1)));
//        }
//    }
//
//
//    public int minCount(String s, String p) {
//        int m = s.length();
//        int n = p.length();
//        int[][] dp = new int[m + 1][n + 1];
//        editDistDP(s, p, m, n, dp);
//        return dp[m][n];
//    }
//
//
//    private void editDistDP(String s, String p, int m, int n, int[][] dp) {
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                if (i == 0)
//                    dp[i][j] = j;
//                else if (j == 0)
//                    dp[i][j] = i;
//                else if (s.charAt(i - 1) == p.charAt(j - 1))
//                    dp[i][j] = dp[i - 1][j - 1];
//                else {
//                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
//                }
//            }
//        }
//    }
}
