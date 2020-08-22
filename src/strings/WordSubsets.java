package strings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-subsets/
public class WordSubsets {
    public static void main(String[] args) {
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = {"oo", "eo"};
        wordSubsets(A, B);
    }


    public static List<String> wordSubsets(String[] A, String[] B) {
        int[] bMap = new int[26];
        List<String> result = new ArrayList<>();
        for (String s : B) {
            int[] map = getWordMap(s);
            for (int i = 0; i < 26; i++) {
                //This will help is adding the duplicate chars from the same String but not from the other String
                bMap[i] = Math.max(map[i], bMap[i]);
            }
        }

        for (String s : A) {
            int[] map = getWordMap(s);
            if (compareMaps(map, bMap)) {
                result.add(s);
            }
        }
        return result;
    }

    public static boolean compareMaps(int[] map, int[] bMap) {
        for (int i = 0; i < 26; i++) {
            if (map[i] < bMap[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] getWordMap(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
}
