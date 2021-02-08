package DataStructures.NewWork.LCStrings;

import java.util.*;

public class WordBreak_2_Trie {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        System.out.println(new WordBreak_2_Trie().wordBreak("aaaaaaaaaa", list));
    }

    Map<Integer, List<String>> cache = new HashMap();

    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = buildTrie(wordDict);
        return search(s, 0, root);
    }


    private List<String> search(String s, int idx, TrieNode root) {
        int n = s.length();
        List<String> ans = new ArrayList();
        if (idx == n) return ans;
        if (cache.containsKey(idx)) return cache.get(idx);
        TrieNode node = root;

        for (int i = idx; i < n; i++) {
            int c = s.charAt(i) - 'a';
            node = node.next[c];
            if (node == null) break;

            if (node.isWord) {
                String sub = s.substring(idx, i + 1);
                if(i == n-1) {
                    ans.add(sub);
                    break;
                }
                List<String> result = search(s, i + 1, root);
                if (!result.isEmpty()) {
                    StringBuilder builder = new StringBuilder();
                    for (String str : result) {
                        builder.append(sub).append(' ').append(str);
                        ans.add(builder.toString());
                        builder.setLength(0);
                    }
                }
            }
        }
        cache.put(idx, ans);
        return ans;

    }


    private TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (node.next[c] == null) {
                    node.next[c] = new TrieNode();
                }
                node = node.next[c];
            }
            node.isWord = true;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isWord;
    }
}
