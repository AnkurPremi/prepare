package DataStructures.tempDelete;

public class class1 {
}


class WordDictionary {

    TrieNode[] nodes;
    /** Initialize your data structure here. */
    public WordDictionary() {
        nodes = new TrieNode[501];
    }

    public void addWord(String word) {
        int len = word.length();
        if(nodes[len] == null){
            nodes[len] = new TrieNode();
        }
        add(nodes[len], word);
    }

    private void add(TrieNode root, String s){
        TrieNode node = root;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(node.next[c - 'a'] == null){
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        int len = word.length();
        if(nodes[len] == null) return false;
        return search(word, nodes[len], 0);
    }

    private boolean search(String s, TrieNode root, int idx){
        if(idx == s.length()) return true;
        TrieNode node = root;

        for(int j = idx ; j < s.length() ; j++){
            char c = s.charAt(j);
            if(c == '.'){
                for(int i = 0 ; i < 26 ; i++){
                    if(node.next[i] == null) continue;

                    if(search(s, node.next[i], j + 1)){
                        return true;
                    }
                }
                return false;
            }
            if(node.next[c - 'a'] == null) return false;
            node = node.next[c - 'a'];
            if(node.isWord && j == s.length() - 1) return true;
        }
        return false;
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