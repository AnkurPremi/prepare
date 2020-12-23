package DataStructures.Mock;

import java.util.Arrays;

public class SmallestSubSeq {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(new SmallestSubSeq().smallestSubsequence(s));
    }

    //first gather the last indices of the distinct chars
//start from left add the char to the result
//if the previous character added is greater than the current char
// and there exists a larger character index in future
//we replace the prev character with current
//and make the count of prev as 0 in present window

        public String smallestSubsequence(String s) {
            int[] lastIdx = new int[26], present = new int[26];
            char[] arr = s.toCharArray();
            for (int i = 0; i < s.length(); i++)
                lastIdx[s.charAt(i) - 'a'] = i;

            int writer = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (present[c - 'a']++ > 0) continue; // if I have same character with me at lower index in ans

                while (writer > 0 && arr[writer - 1] > c && i < lastIdx[arr[writer - 1] - 'a']) {
                    present[arr[writer - 1] - 'a'] = 0;
                    writer--;
                }

                arr[writer++] = c;
            }
            return new String(arr, 0, writer);
        }

}
