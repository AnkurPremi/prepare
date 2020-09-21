package DataStructures.problemsArray;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        new WordSearchII().findWords(board, words);
    }


    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                helper(board, i, j, result, root);
            }
        }
        return result;
    }

    public void helper(char[][] board, int i, int j, List<String> result, TrieNode root) {
        char c = board[i][j];
        if (c == '#' || root.arr[c - 'a'] == null) return;
        root = root.arr[c - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        if (i > 0) helper(board, i - 1, j, result, root);
        if (j > 0) helper(board, i, j - 1, result, root);
        if (i < board.length-1) helper(board, i + 1, j, result, root);
        if (j < board[0].length-1) helper(board, i, j + 1, result, root);
        board[i][j] = temp;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.arr[c - 'a'] == null) {
                    node.arr[c - 'a'] = new TrieNode();
                }
                node = node.arr[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] arr = new TrieNode[26];
        String word;
    }
}
