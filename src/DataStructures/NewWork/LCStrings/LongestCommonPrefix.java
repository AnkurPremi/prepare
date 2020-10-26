package DataStructures.NewWork.LCStrings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] words = {"dog","racecar","car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(words));
    }

    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        int n = strs.length;
        if(n == 0) return ans;
        TrieNode root = buildTrie(strs[0]);
        return search(root, strs);
    }


    public String search(TrieNode root, String[] words){
        int min = 20000;
        for(int i=1 ; i<words.length ; i++){
            int count = 0;
            TrieNode node = root;
            for(char c : words[i].toCharArray()){
                if(node.next[c-'a'] == null){
                    break;
                }
                node = node.next[c-'a'];
                count++;
            }
            if(count == 0) return "";
            min = Math.min(count, min);
        }
        return words[0].substring(0, min);
    }

    public TrieNode buildTrie(String word){
        TrieNode root = new TrieNode();
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.next[c-'a'] == null){
                node.next[c-'a'] = new TrieNode();
            }
            node = node.next[c-'a'];
        }
        node.isWord = true;
        return root;
    }

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean isWord;
        boolean isPrefix;
    }
}
