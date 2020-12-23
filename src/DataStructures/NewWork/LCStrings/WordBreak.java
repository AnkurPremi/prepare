package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> list= new ArrayList<>(Arrays.asList("leet","code"));
        System.out.println(new WordBreak().wordBreak("leetcode", list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        TrieNode root = buildTrie(wordDict);
        boolean[] seen = new boolean[n + 1];
        seen[n] = true;

        for(int i = n-1 ; i>=0 ; i--){
            TrieNode node = root;
            for(int j = i ; node != null && j < n ; j++){
                char c = s.charAt(j);
                node = node.next[c - 'a'];
                if(node != null && node.isWord && seen[j + 1]){
                    seen[i] = true;
                    break;
                }
            }
        }
        return seen[0];
    }

    private TrieNode buildTrie(List<String> words){
        TrieNode root = new TrieNode();
        for(String s : words){
            TrieNode node = root;
            for(int i=0 ; i<s.length() ; i++){
                char c = s.charAt(i);
                if(node.next[c - 'a'] == null){
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean isWord;
    }
}
