package DataStructures.HashTable;

import java.util.*;

public class ReplaceWords {
    public static void main(String[] args) {
        List<String> d = new ArrayList<>(Arrays.asList("cat", "bat", "rat"));
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new ReplaceWords().replaceWords(d, sentence));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        String[] words = sentence.split(" ");
        TrieNode root = buildTrie(words);
        Map<Integer, String> map = searchAndPrepare(root, dictionary);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(i)) {
                builder.append(map.get(i)).append(" ");
            } else {
                builder.append(words[i]).append(" ");
            }
        }
        return builder.toString().trim();
    }

    public Map<Integer, String> searchAndPrepare(TrieNode root, List<String> d) {
        Map<Integer, String> map = new HashMap<>();
        for (String s : d) {
            TrieNode node = root;
            List<Integer> wordIdx = null;
            for (char c : s.toCharArray()) {
                if (node.next[c - 'a'] == null || node.next[c - 'a'].wordsIdx == null) {
                    break;
                }
                wordIdx = node.next[c - 'a'].wordsIdx;
//                node.next[c - 'a'].wordsIdx = null;
                node = node.next[c - 'a'];
            }
            node.wordsIdx = null;
            if (wordIdx != null) {
                addToMap(wordIdx, s, map);
            }
        }
        return map;
    }

    public void addToMap(List<Integer> list, String word, Map<Integer, String> map) {
        for (int i : list) {
            if(map.containsKey(i)) {
                if (word.length() < map.get(i).length())
                    map.put(i, word);
            }
            else {
                map.put(i, word);
            }
        }
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (char c : words[i].toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                    node.next[c - 'a'].wordsIdx = new ArrayList<>();
                }
                node.next[c - 'a'].wordsIdx.add(i);
                node = node.next[c - 'a'];
            }
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        List<Integer> wordsIdx;
    }
}
