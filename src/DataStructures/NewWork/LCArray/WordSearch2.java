package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(new WordSearch2().findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, words, root, result);
            }
        }
        return result;
    }

    private void search(char[][] board, int r, int c, String[] words, TrieNode node, List<String> result) {
        if (board[r][c] == '0') return;

        char ch = board[r][c];
        node = node.next[ch - 'a'];
        if (node == null) return;

        if (node.idx >= 0) {
            result.add(words[node.idx]);
            node.idx = -1;
        }

        board[r][c] = '0';

        if (r > 0) search(board, r - 1, c, words, node, result);
        if (c > 0) search(board, r, c - 1, words, node, result);
        if (r < board.length - 1) search(board, r + 1, c, words, node, result);
        if (c < board[0].length - 1) search(board, r, c + 1, words, node, result);

        board[r][c] = ch;
    }


    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (int j = 0; j < words[i].length(); j++) {
                int c = words[i].charAt(j) - 'a';

                if (node.next[c] == null) {
                    node.next[c] = new TrieNode();
                }
                node = node.next[c];
            }
            node.idx = i;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int idx = -1;
    }
}
