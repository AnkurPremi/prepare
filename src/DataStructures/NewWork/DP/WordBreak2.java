package DataStructures.NewWork.DP;

import java.util.*;

public class WordBreak2 {
    public static void main(String[] args) {
        String[] words = {"cat", "cats", "and", "sand", "dog"};
        String s = "catsanddog";
        System.out.println(new WordBreak2().wordBreak(s, Arrays.asList(words)));
    }
    Map<Integer, List<String>> cache;
    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = buildTrie(wordDict);
        this.cache = new HashMap<>();
        return search(root, s, 0);
    }

    private List<String> search(TrieNode root, String s, int idx){
        if(cache.containsKey(idx))
            return cache.get(idx);
        List<String> result = new ArrayList();
        int n = s.length();
        if(idx == n) return result;
        TrieNode node = root;

        for(int i=idx ; i<n ; i++){
            char c = s.charAt(i);
            node = node.next[c - 'a'];

            if(node == null) break;

            if(node.isWord){
                String word = s.substring(idx, i+1);
                if(i == n - 1){ //reached end
                    result.add(word);
                } else{
                    List<String> list = search(root, s, i+1);
                    for(int j=0 ; j<list.size() ; j++){
                        result.add(word + " " + list.get(j));
                    }
                }
            }
        }
        cache.put(idx, result);
        return result;
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

//    Map<String, List<String>> map;
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        Set<String> wordSet = new HashSet<>(wordDict);
//        map = new HashMap();
//        return helper(s, wordSet);
//    }
//
//    private List<String> helper(String s, Set<String> wordSet){
//        List<String> result = new ArrayList();
//        if(s.isEmpty()) return result;
//
//        //lookup in cache
//        if(map.containsKey(s))
//            return map.get(s);
//
//        if(wordSet.contains(s))
//            result.add(s);
//
//        for(int i=1 ; i<s.length() ; i++){
//            String sub = s.substring(i);
//            if(wordSet.contains(sub)){
//                List<String> list = helper(s.substring(0, i), wordSet);
//                for(int j=0 ; j<list.size() ; j++){
//                    result.add(list.get(j) + " " + sub);
//                }
//            }
//        }
//        map.put(s, result);
//        return result;
//    }
}
