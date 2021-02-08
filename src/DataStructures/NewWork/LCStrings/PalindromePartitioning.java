package DataStructures.NewWork.LCStrings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePartitioning().minCut(s));
    }

    public int minCut1(String s) {
        // validate input
        if (s == null || s.length() <= 1) {
            return 0;
        }
        // dp
        int N = s.length();
        int[] dp = IntStream.range(0, N).toArray(); // initial value: dp[i] = i

        for (int mid = 1; mid <  N; mid++) { // iterate through all chars as mid point of palindrome
            // CASE 1. odd len: center is at index mid, expand on both sides
            for (int start = mid, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
            // CASE 2: even len: center is between [mid-1,mid], expand on both sides
            for (int start = mid - 1, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
        }
        return dp[N - 1];
    }

    int left = -1, right = -1;

    public int minCut(String s) {

        Deque<Pair> dq = new LinkedList();

        for (int i = 0; i < s.length(); i++) {
            int odd = helper(s, i, i);
            int even = helper(s, i, i + 1);
            checkPartition(dq, Math.max(odd, even + 1));
        }

        return dq.size();
    }

    private void checkPartition(Deque<Pair> dq, int len) {
        if(!dq.isEmpty() && dq.peekLast().len > left + len) return;



        dq.addLast(new Pair(left, len));
    }

    class Pair{
        int left;
        int len;
        Pair(int left, int len){
            this.left = left;
            this.len = len;
        }
    }

    private int helper(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        if(start < 0)
            start++;

        left = start;
        right = end;

        return count;
    }
}
