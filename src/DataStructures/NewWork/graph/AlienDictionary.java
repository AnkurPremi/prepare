package DataStructures.NewWork.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.

 You are given a list of strings words from the dictionary, where words are sorted lexicographically by the rules of this new language.

 Derive the order of letters in this language, and return it. If the given input is invalid, return "". If there are multiple valid solutions, return any of them.
 Input: words = ["wrt","wrf","er","ett","rftt"]
 Output: "wertf"
 **/
public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(new AlienDictionary().alienOrder(words));
    }

//Runtime - O(C) ... all characters in the words
        public String alienOrder(String[] words) {

            Set<Integer>[] graph = new Set[26];

            for (String word : words) {
                for (char c : word.toCharArray()) {
                    graph[c - 'a'] = new HashSet<>();
                }
            }

            // Step 1: Find all edges and add reverse edges to reverseAdjList.
            for (int i = 0; i < words.length - 1; i++) {
                String word1 = words[i];
                String word2 = words[i + 1];
                // Check that word2 is not a prefix of word1.
                if (word1.length() > word2.length() && word1.startsWith(word2)) {
                    return "";
                }
                // Find the first non match and insert the corresponding relation.
                for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                    int c1 = word1.charAt(j) - 'a';
                    int c2 = word2.charAt(j) - 'a';
                    if (c1 != c2) {
                        graph[c1].add(c2);
                        break;
                    }
                }
            }


            StringBuilder ans = new StringBuilder();
            boolean[] v = new boolean[26];
            boolean[] f = new boolean[26];

            for (int i = 0; i < 26; i++) {
                if (graph[i] == null) continue;
                if (!dfs(graph, i, v, f, ans)) {
                    return "";
                }
            }
            return ans.reverse().toString();
        }

        private boolean dfs(Set<Integer>[] graph, int letter, boolean[] v, boolean[] f, StringBuilder ans) {
            if (f[letter]) return true;
            if (v[letter]) return false;

            v[letter] = true;

            for (Integer i : graph[letter]) {
                if (!dfs(graph, i, v, f, ans)) {
                    return false;
                }
            }
            f[letter] = true;
            ans.append((char) (letter + 'a'));
            return true;
        }
    }

