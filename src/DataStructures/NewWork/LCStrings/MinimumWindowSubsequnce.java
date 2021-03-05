package DataStructures.NewWork.LCStrings;

public class MinimumWindowSubsequnce {
    public static void main(String[] args) {
        String S = "abcdebdde", T = "bde";
        System.out.println(new MinimumWindowSubsequnce().minWindow(S, T));
    }

    public String minWindow(String S, String T) {
        int n = S.length(), m = T.length();
        if(m > n) return "";

        int start = 0, end = 0;
        int minLen = n + 1, left = -1, right = -1;

        while(end < n){
            int k = 0;
            while(end < n){
                if(S.charAt(end) == T.charAt(k)){
                    k++;
                }
                if(k == m) break;
                end++;
            }

            if(end == n){
               break;
            }

            int prev = end;
            k = m - 1;
            while(prev >= 0){
                if(S.charAt(prev) == T.charAt(k)){
                    k--;
                }
                if(k < 0) break;
                prev--;
            }

            if(minLen > end - prev + 1){
                minLen = end - prev + 1;
                left = prev;
                right = end;
            }

            end = prev + 1;

        }

        return minLen == n + 1 ? "" : S.substring(left, right + 1);
    }


    public String minWindow1(String S, String T) {
        //move from left to right initially to expand the window
        //when subsequence found.. try contracting that window by moving from right to left
        //till we find the first char of the string 'T'

        int start = 0, end = 0;
        int lenT = T.length(), lenS = S.length();
        int tIdx = 0;
        int minLen = lenS + 1;

        while(end < lenS){
            while(end < lenS && tIdx < lenT){
                if(S.charAt(end) == T.charAt(tIdx)){
                    tIdx++;
                }
                if(tIdx == lenT) break;
                end++;
            }

            if(end == lenS) break;

            int left = end;
            tIdx = lenT - 1;
            while(left >= 0){
                if(S.charAt(left) == T.charAt(tIdx)){
                    tIdx--;
                }

                if(tIdx < 0) break;
                left--;
            }

            if(end - left + 1 < minLen){
                minLen = end - left + 1;
                start = left;
            }

            end = left + 1;
            tIdx = 0;
        }

        return minLen == lenS + 1 ? "" : S.substring(start, start + minLen);
    }
}
