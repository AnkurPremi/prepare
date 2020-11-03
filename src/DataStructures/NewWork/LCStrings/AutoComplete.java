package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AutoComplete {
    public static void main(String[] args) {
        String[] arr = {"mobile","mouse","moneypot","monitor","mousepad"};
        String word = "mouse";
        System.out.println(new AutoComplete().suggestedProducts(arr, word));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        TrieNode root = buildTrie(products);
        char[] arr = searchWord.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            List<String> ans = search(products, i, arr, root);
            if(ans.size() > 3)
                result.add(Arrays.asList(ans.get(0), ans.get(1), ans.get(2)));
            else
                result.add(ans);
        }

        return result;
    }

    public List<String> search(String[] words, int idx, char[] arr, TrieNode root) {
        TrieNode node = root;
        List<Integer> result = null;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= idx; i++) {
            char c = arr[i];
            if (node.next[c - 'a'] == null) break;
            result = node.next[c - 'a'].indices;
            node = node.next[c - 'a'];
        }
        if (result == null) return ans;
        for (int i : result) {
            ans.add(words[i]);
        }
        if(result.size() > 3) Collections.sort(result);
        return ans;
    }


    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (char c : words[i].toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node.next[c - 'a'].indices.add(i);
                node = node.next[c - 'a'];
            }
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next;
        boolean isWord;
        List<Integer> indices;

        TrieNode() {
            next = new TrieNode[26];
            indices = new ArrayList<>();
        }
    }
}
