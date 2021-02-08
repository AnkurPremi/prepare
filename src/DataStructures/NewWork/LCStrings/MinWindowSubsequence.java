package DataStructures.NewWork.LCStrings;

public class MinWindowSubsequence {
    public static void main(String[] args) {
        System.out.println(new MinWindowSubsequence().minWindow("abcdebdde", "bde"));
    }

    public String minWindow(String S, String T) {
        int count = 0, len = T.length();
        int[] map = new int[26];
        for(int i=0 ; i<len ; i++){
            map[T.charAt(i) - 'a']++;
        }

        int[] lookup = map.clone();
        int ansStart = -1, ansEnd = -1;

        int start = 0, end = 0, minLen = S.length() + 1;
        while(end < S.length()){
            char c = S.charAt(end);
            if(lookup[c - 'a'] > 0){
                if(map[c - 'a'] > 0){
                    count++;
                }
                map[c - 'a']--;
            }

            if(count == len && hasSubSequence(S, start, end, T)){
                if(minLen > end - start){
                    ansStart = start;
                    ansEnd = end;
                    minLen = end - start;
                }

                boolean seqPresent = true;
                while(count == len){

                    char ch = S.charAt(start);
                    if(lookup[ch - 'a'] > 0){
                        seqPresent = false;
                        map[ch - 'a']++;
                        count--;
                    }
                    start++;
                    if(seqPresent){
                        if(minLen > end - start){
                            ansStart = start;
                            ansEnd = end;
                            minLen = end - start;
                        }
                    }
                }
            }

            end++;
        }
        return ansStart == -1 ? "" : S.substring(ansStart, ansEnd + 1);
    }

    private boolean hasSubSequence(String s, int start, int end, String T){
        int i = start, j = 0;

        while(i <= end){
            if(s.charAt(i) == T.charAt(j)){
                j++;
            }
            i++;
        }

        return j == T.length();
    }
}
