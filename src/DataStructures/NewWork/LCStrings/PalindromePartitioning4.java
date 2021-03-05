package DataStructures.NewWork.LCStrings;

public class PalindromePartitioning4 {
    public static void main(String[] args) {
        String s = "dasda";
        System.out.println(new PalindromePartitioning4().checkPartitioning(s));
    }

    public boolean checkPartitioning(String s) {
        int N = s.length();
        char[] A = s.toCharArray();

// build dp table
        boolean[][] dp = new boolean[N][N];
        for (int i = N - 1; i >= 0; --i) {
            for (int j = i; j < N; ++j) {
                if (A[i] == A[j]) dp[i][j] = ((i + 1 <= j - 1) ? dp[i + 1][j - 1] : true);
                else dp[i][j] = false;
            }
        }

// iterate every mid and then check: left, mid and right
        for (int i = 1; i < N - 1; ++i) {
            for (int j = i; j < N - 1; ++j) {
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][N - 1]) return true;
            }
        }

        return false;
    }
}