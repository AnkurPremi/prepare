package DataStructures.HashTable;

import java.util.*;

public class AlienDict {
    public static void main(String[] args) {
        String[] words = {"apple","app"}; String order = "abcdefghijklmnopqrstuvwxyz";
        Set<Character> set = new HashSet<>();
        Iterator ot =  set.iterator();
        while(ot.hasNext()){

        }
        System.out.println(new AlienDict().isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if (!areInOrder(words[i - 1], words[i], map)) return false;
        }
        return true;
    }

    public boolean areInOrder(String word1, String word2, Map<Character, Integer> map) {
        int m = word1.length();
        int n = word2.length();
        int sameCount = 0;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                sameCount++;
                continue;
            } else if (map.get(word1.charAt(i)) < map.get(word2.charAt(j))) {
                return true;
            }
            else return false;
        }
        if (sameCount == Math.min(m, n)) {
            return sameCount == m;
        }
        return true;
    }



}
