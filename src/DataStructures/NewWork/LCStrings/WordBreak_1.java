package DataStructures.NewWork.LCStrings;

import java.util.*;

public class WordBreak_1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(new WordBreak_1().wordBreak("catsandog", list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet(wordDict);
        Set<String> badWords = new HashSet();
        return search(s, 0, words, badWords);
    }

    private boolean search(String s, int idx, Set<String> words, Set<String> badWords) {
        if (s.isEmpty()) return true;
        if (badWords.contains(s)) return false;

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (words.contains(sub) && search(s.substring(i + 1), i + 1, words, badWords)) {
                return true;
            }
        }
        badWords.add(s);
        return false;
    }
}
