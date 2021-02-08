package DataStructures.NewWork.LCStrings;

public class AddAndSearchWordDictionary {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}

class WordDictionary {

    TrieNode[] nodes;
    /** Initialize your data structure here. */
    public WordDictionary() {
        nodes = new TrieNode[500];
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

