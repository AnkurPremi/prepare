package DataStructures.NewWork.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords {
    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(words));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        HashSet<String> nonCombination = new HashSet<>();
        for (String word : words) if (dfs(word, wordSet, nonCombination)) ans.add(word);
        return ans;
    }

    boolean dfs(String word, HashSet<String> wordSet, HashSet<String> nonCombination) {
        if (nonCombination.contains(word)) return false;
        for (int i = 1; i < word.length(); i++) {
            if (wordSet.contains(word.substring(0, i))) {
                String suffix = word.substring(i);
                if (wordSet.contains(suffix) || dfs(suffix, wordSet, nonCombination)) {
                    wordSet.add(word); // can treat concatenated word as a new word for quickly lookup later
                    return true;
                }
            }
        }
        nonCombination.add(word);
        return false;
    }
}
