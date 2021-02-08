package DataStructures.NewWork.LCStrings;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aaabbaaa";
        System.out.println(new StringCompression().getLengthOfOptimalCompression(s, 2));
        System.out.println(new StringCompression().compress(s.toCharArray()));
    }

    public int compress1(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1) {
                char[] countArr = String.valueOf(count).toCharArray();
                for (char c : countArr)
                    chars[indexAns++] = c;
            }
        }
        return indexAns;
    }

    public int compress(char[] chars) {
        int slowPtr = 0, fastPtr = 0;
        while(fastPtr < chars.length){
            char ch = chars[fastPtr];
            int count = 0;
            while(fastPtr < chars.length && chars[fastPtr] == ch){
                count++;
                fastPtr++;
            }

            if(count == 1){
                chars[slowPtr] = ch;
                slowPtr++;
                continue;
            }

            String s = String.valueOf(count);
            chars[slowPtr] = ch;
            slowPtr++;
            for(int i=0 ; i<s.length() ; i++){
                chars[slowPtr++] = s.charAt(i);
            }
        }
        return slowPtr;
    }

    int dp[][];
    public int getLengthOfOptimalCompression(String ss, int k) {
        char[] s = ss.toCharArray();

        dp = new int[s.length][k + 1];
        for(int[] row : dp) Arrays.fill(row, -1);

        int res = dfs(s, 0, k);
        // for(int[] row : dp) System.out.println(Arrays.toString(row));
        return res;
    }

    private int dfs(char[] s, int curIdx, int k) {
        // reach end or we can simply delete all
        if(curIdx == s.length || s.length - curIdx <= k) return 0;

        if(dp[curIdx][k] != -1) return dp[curIdx][k];

        int[] fre = new int[26];
        int most = 0, ans = Integer.MAX_VALUE; // most is the highest frequency

        // i - curIdx + 1 - most. count of chars we need to delete
        // but we cannot break. Because when most change, rest could also change.
        // So we must iterate to end
        for(int i = curIdx; i < s.length; i++) {
            int idx = s[i] - 'a';
            fre[idx]++;

            most = Math.max(most, fre[idx]);
            if(k >= i - curIdx + 1 - most) // only recurse when we can delete all other chars
                ans = Math.min(ans, getLen(most) + 1 + dfs(s, i + 1, k - (i - curIdx + 1 - most)));
        }
        dp[curIdx][k] = ans;
        return ans;
    }

    private int getLen(int most) {
        if(most == 1) return 0;
        if(most < 10) return 1;
        if(most < 99) return 2;
        return 3;
    }
}
