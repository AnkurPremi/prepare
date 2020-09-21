package DataStructures.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String[] words = {"cats", "dog", "an", "and", "cat"};
        List<String> word1 = new ArrayList<>(Arrays.asList(words));
        String s = "catsandog";
        System.out.println(new WordBreak().wordBreak(s, word1));
    }

    public boolean wordBreak(String s, List<String> words) {
        TrieNode root = buildTrie(words);
        TrieNode node = root;
        boolean[] seen = new boolean[s.length()+1];
        seen[s.length()] = true;

        for(int i=s.length()-1 ; i>=0 ; i--){
            node = root;
            for(int j=i ; node != null && j<s.length() ; j++){
                node = node.next[s.charAt(j) - 'a'];
                if(node != null && node.isWord && seen[j + 1]){
                    seen[i] = true;
                    break;
                }
            }
        }
        return seen[0];
    }

    public TrieNode buildTrie(List<String> words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.next[c-'a'] == null){
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'] ;
            }
            node.isWord = true;
        }
        return root;
    }

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean isWord;
    }

//
//
//    public boolean wordBreak(String s, List<String> words) {
//        TrieNode root = buildTrie(words);
//        TrieNode node = root;
//        int prevIdx = 0;
//        boolean found = false;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (node.next[c - 'a'] == null) {
//                if (found) {
//                    found = false;
//                    i = prevIdx;
//                    node = root;
//                    continue;
//                } else {
//                    return false;
//                }
//            }
//            node = node.next[c - 'a'];
//            if (node.isWord) {
//                found = true;
//                prevIdx = i;
//            }
//        }
//        return true;
//    }
//
//    private TrieNode buildTrie(List<String> words) {
//        TrieNode root = new TrieNode();
//        for (String word : words) {
//            TrieNode node = root;
//            for (char c : word.toCharArray()) {
//                if (node.next[c - 'a'] == null) {
//                    node.next[c - 'a'] = new TrieNode();
//                }
//                node = node.next[c - 'a'];
//            }
//            node.isWord = true;
//        }
//        return root;
//    }
//
//    class TrieNode {
//        TrieNode[] next = new TrieNode[26];
//        boolean isWord;
//    }
}
