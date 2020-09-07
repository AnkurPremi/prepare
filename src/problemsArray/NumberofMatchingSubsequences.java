package problemsArray;

import java.text.StringCharacterIterator;
import java.util.*;

//https://leetcode.com/problems/number-of-matching-subsequences/discuss/117634/Efficient-and-simple-go-through-words-in-parallel-with-explanation
public class NumberofMatchingSubsequences {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(new NumberofMatchingSubsequences().numMatchingSubseq1(s, words));
    }

    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, new TreeSet()));
            map.get(c).add(i);
        }
        int count = 0;
        for (String word : words) {
            Integer idx = -1;
            int j = 0;
            for (; j < word.length(); j++) {
                if (!map.containsKey(word.charAt(j))) {
                    break;
                }
                idx = map.get(word.charAt(j)).ceiling(idx);
                if (idx == null) break;
                idx++;
            }
            if (j == word.length()) count++;
        }
        return count;
    }

    //another solution-fast
    public int numMatchingSubseq1(String S, String[] words) {
        List<StringBuilder>[] waiting = new List[26];
        for (int c = 'a'; c <= 'z'; c++) {
            waiting[c - 'a'] = new ArrayList<>();
        }

        for (String word : words) {
            waiting[word.charAt(0) - 'a'].add(new StringBuilder(word));
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            List<StringBuilder> advance = waiting[c - 'a'];
            waiting[c - 'a'] = new ArrayList<>();
            for (StringBuilder sb : advance) {
                sb.deleteCharAt(0);
                if (sb.length() != 0) {
                    waiting[sb.charAt(0) - 'a'].add(sb);
                } else {
                    count++;
                }
            }
        }
        StringCharacterIterator stringCharacterIterator;
        return count;
    }
}
