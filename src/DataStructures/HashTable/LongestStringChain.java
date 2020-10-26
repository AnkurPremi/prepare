package DataStructures.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class LongestStringChain {
    public static void main(String[] args) {
        String[] arr = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        System.out.println(new LongestStringChain().longestStrChain(arr));
    }

    public int longestStrChain(String[] words) {
        TreeMap<Integer,String> map = new TreeMap<>();
        if (words.length == 1) return 1;
        TrieNode root = buildTrie(words);
        print(words);
        return findMaxLength(words, root);
    }

    public void print(String[] words){
        for(String s : words){
            System.out.print(s);
            System.out.print(", ");
        }
    }

    private int findMaxLength(String[] words, TrieNode root) {
        int max = 0;
        for (String s : words) {
            if(s.equals("cdfhpvxzzz")){
                System.out.println("adsa");
            }
            TrieNode node = root;
            int wordCount = 0;
            for (char c : s.toCharArray()) {
                if (node.next[c - 'a'].isWord) {
                    wordCount++;
                }
                node = node.next[c - 'a'];
            }
            max = Math.max(max, wordCount);
        }
        return max;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            char[] arr = words[i].toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if(words[i].equals("zczpzfvdhx")){
                System.out.println(s);
            }
            for (char c : s.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isWord = true;
            words[i] = s;
        }
        return root;
    }


    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isWord;
    }
}
