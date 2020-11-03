package DataStructures.NewWork.LCStrings;

import java.util.Stack;

public class SmallestSubSeqOFDistinctChars {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(new SmallestSubSeqOFDistinctChars().smallestSubsequence(s));
    }

    public String smallestSubsequence(String s) {
        int[] lastIdx = new int[26], present = new int[26];
//        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0 ; i<s.length() ; i++)
            lastIdx[s.charAt(i) - 'a'] = i;

        int writer = 0;
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);

            if(present[c - 'a']++ > 0) continue;

            while(writer > 0 && arr[writer - 1] > c && i < lastIdx[arr[writer - 1] - 'a']){
                present[arr[writer - 1] - 'a'] = 0;
                writer--;
            }

            arr[writer++] = c;
        }
        return new String(arr, 0, writer);
    }
}
