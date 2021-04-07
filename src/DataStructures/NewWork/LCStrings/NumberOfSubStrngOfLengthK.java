package DataStructures.NewWork.LCStrings;

import java.util.Arrays;

public class NumberOfSubStrngOfLengthK {
    public static void main(String[] args) {
        String s = "havefunonleetcode";
        int K = 5;
        System.out.println(new NumberOfSubStrngOfLengthK().numKLenSubstrNoRepeats(s, K));
    }

    public int numKLenSubstrNoRepeats(String S, int K) {
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int start = 0, end = 0, n = S.length();
        int ans = 0;

        while(end < n){
            int idx = S.charAt(end) - 'a';
            while(last[idx] != -1){
                last[S.charAt(start) - 'a'] = -1;
                start++;
            }
            last[idx] = end;
            ans += end - start + 1 >= K ? 1 : 0;
            end++;
        }

        return ans;
    }
}
