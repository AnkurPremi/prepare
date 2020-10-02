package DataStructures.strings;

import DataStructures.stacks.RemoveAdjacentDupStr2;

import java.util.HashMap;
import java.util.Map;

public class RepeatedSubStringPattern {
    public static void main(String[] args) {
        String s = "aaaaa";
        System.out.println(new RepeatedSubStringPattern().repeatedSubstringPattern(s));
    }

    public boolean repeatedSubstringPattern(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int pStart = 0;
        int pEnd = 0;
        int end = 0;
        while (end < s.length()) {
            if (!map.containsKey(s.charAt(end)) && end > s.length() / 2) {
                return false;
            }
            if (map.containsKey(s.charAt(end))) {
                //we may have a probable patterns
                if (s.charAt(pStart) == s.charAt(end)) {
                    int gap = pEnd == 0 ? end - pStart : pEnd - pStart + 1;
                    int i = pStart;
                    int j = end;
                    while (j < s.length() && j < (end + gap) && s.charAt(i) == s.charAt(j)) {
                        i++;
                        j++;
                    }
                    if (j == s.length()) {
                        if (j - end != gap)
                            return false;
                        else
                            return true;
                    } else if (j - end != gap) {
                        pEnd = j;
                    } else {
                        if (pEnd == 0) {
                            pEnd = end - 1;
                        }
                        end = end + gap;
                    }
                }
            } else {
                if(pEnd != 0){
                    pEnd = end;
                }
                map.put(s.charAt(end), end);
                end++;
            }

        }
        return false;
    }
}
