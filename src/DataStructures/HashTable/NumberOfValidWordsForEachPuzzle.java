package DataStructures.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfValidWordsForEachPuzzle {
    public static void main(String[] args) {
        String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        System.out.println(new NumberOfValidWordsForEachPuzzle().findNumOfValidWords(words, puzzles));
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        Map<Integer, Integer> map = new HashMap<>();

        for (String w : words) {
            int mask = 0;
            for (int i = 0; i < w.length(); i++) {
                mask |= 1 << (w.charAt(i) - 'a');
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (String p : puzzles) {
            int mask = 0;
            for (int i = 0; i < p.length(); i++) {
                mask |= 1 << (p.charAt(i) - 'a');
            }
            int c = 0;
            int sub = mask;
            int first = 1 << (p.charAt(0) - 'a');
            while (true) {
                if ((sub & first) == first && map.containsKey(sub)) {
                    c += map.get(sub);
                }
                System.out.println(sub);
                if (sub == 0) break;
                sub = (sub - 1) & mask; // get the next substring
            }

            res.add(c);
        }

        return res;
    }
}
