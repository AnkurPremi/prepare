package DataStructures.strings;

//Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
//Strings consists of lowercase English letters only and the length of both DataStructures.strings s and p will not be larger than 20,100.
//
//The order of output does not matter.
//
//Example 1:
//
//Input:
//s: "cbaebabacd" p: "abc"
//
//Output:
//[0, 6]
//
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".

import java.util.ArrayList;
import java.util.List;

public class AnagramsInString {
    public static void main(String[] args) {
        String s = "cbabbccacbac";
        String p = "abc";
        List<Integer> list = getAnagramsStartIdx(s, p);
        System.out.println(list);
    }

    static List<Integer> getAnagramsStartIdx(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) return list;

        //Storing pattern p - for lookup
        int[] hash = new int[256];
        for (char chr : p.toCharArray()) {
            hash[chr]++;
        }

        int count = p.length(), left = 0, right = 0;
        //Start moving from left to right
        //right ptr will move with every step
        //left pointer will move only when the diff b/w left and right == p.length

        while (right < s.length()) {
            if (hash[s.charAt(right)] > 0) {
                count--;//check the length which is yet to be traversed
            }
            hash[s.charAt(right)]--;
            right++;//move right

            //if the anagram is found add the left ptr to the list
            if (count == 0) {
                list.add(left);
            }

            //Now, if we have reached the length of the String s
            //move the left ptr forward and reset the hash & count
            if (right - left >= p.length()) {
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return list;
    }
}
