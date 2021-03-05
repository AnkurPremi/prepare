package DataStructures.tempDelete;

import java.util.HashMap;
import java.util.Map;

public class class2 {
}

class WordDictionary1 {

    /** Initialize your data structure here. */
    Map<Integer, TrieNode> map;
    public WordDictionary1() {
        map = new HashMap();
    }

    public void addWord(String word) {
        int len = word.length();
        if(!map.containsKey(len)){
            map.put(len, new TrieNode());
        }
        addWord(map.get(len), word);
    }

    public boolean search(String word) {
        int len = word.length();
        return search(map.get(len), word, 0);
    }

    private boolean search(TrieNode node, String word, int idx){
        int n = word.length();
        if(idx == n) return true;

        for(int i = idx ; i < n ; i++){
            char c = word.charAt(i);

            if(c == '.'){

                for(int j = 0 ; j < 26 ; j++){
                    if(node.next[i] != null && search(node.next[i], word, i + 1)){
                        return true;
                    }
                }
                return false;

            }

            if(node.next[c - 'a'] == null) return false;

            node = node.next[c - 'a'];

            if(node.isWord && i == n - 1) return true;
        }

        return false;
    }

    private void addWord(TrieNode root, String word){
        TrieNode node = root;
        for(int i = 0; i < word.length() ; i++){
            char c = word.charAt(i);
            if(node.next[c - 'a'] == null){
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isWord = true;
    }

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */