package Arrays;

//https://leetcode.com/problems/word-search/
public class WordSearch {
    public static void main(String[] args) {
        char[][] matrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new WordSearch().exist(matrix, "ABCCED"));
//        System.out.println(new WordSearch().exist(matrix, "SEE"));
//        System.out.println(new WordSearch().exist(matrix, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isPresent = helper(board, word, 0, i, j);
                if (isPresent) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int pos, int row, int col) {
        if (pos == word.length()) return true;
        if(!isBound(board, row, col)) return false;
        if (board[row][col] != word.charAt(pos)) return false;
        char temp = board[row][col];
        board[row][col] = '0';
        boolean isPresent = helper(board, word, pos+1, row, col - 1)
                            || helper(board, word, pos+1, row, col + 1)
                            || helper(board, word, pos+1, row - 1, col)
                            || helper(board, word, pos+1, row + 1, col);

        board[row][col] = temp;
        return isPresent;
    }
    private boolean isBound(char[][] board, int row, int col){
        return row>=0 && col>=0 && row< board.length && col < board[0].length;
    }
}


////////////////////////////////////one more solution//////////////////////////////////////////////////////////////////
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isPresent = helper(board, word, 0, i, j);
                if (isPresent) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int pos, int row, int col) {
        //if reached at the end with word match..means found the word ..return true
        if (pos == word.length()) return true;

        //check if value of row and col are bound
        if(!isBound(board, row, col)) return false;

        //if the characters do not match return false..try some other path
        if (board[row][col] != word.charAt(pos)) return false;

        //marking the used index with '0'
        char temp = board[row][col];
        board[row][col] = '0';

        //try different paths..going left, right, up and down respectively
        boolean isPresent = helper(board, word, pos+1, row, col - 1)
                || helper(board, word, pos+1, row, col + 1)
                || helper(board, word, pos+1, row - 1, col)
                || helper(board, word, pos+1, row + 1, col);

        //writing back the character to the index
        board[row][col] = temp;

        return isPresent;
    }
    private boolean isBound(char[][] board, int row, int col){
        return row>=0 && col>=0 && row< board.length && col < board[0].length;
    }
}

//
//class Solution {
//    public boolean exist(char[][] board, String word) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                boolean isPresent = helper(board, word, 0, i, j);
//                if (isPresent) return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean helper(char[][] board, String word, int pos, int row, int col) {
//        if (board[row][col] == '0' || board[row][col] != word.charAt(pos)) return false;
//
//        char temp = board[row][col];
//        board[row][col] = '0';
//        pos++;
//        if (pos == word.length()) return true;
//        //check left
//        if (col - 1 >= 0 && board[row][col - 1] == word.charAt(pos)) {
//            boolean isPresent = helper(board, word, pos, row, col - 1);
//            if (isPresent) return true;
//        }
//
//        //check right
//        if (col + 1 < board[0].length && board[row][col + 1] == word.charAt(pos)) {
//            boolean isPresent = helper(board, word, pos, row, col + 1);
//            if (isPresent) return true;
//        }
//
//        //check down
//        if (row - 1 >= 0 && board[row - 1][col] == word.charAt(pos)) {
//            boolean isPresent = helper(board, word, pos, row - 1, col);
//            if (isPresent) return true;
//        }
//
//        //check left
//        if (row + 1 < board.length && board[row + 1][col] == word.charAt(pos)) {
//            boolean isPresent = helper(board, word, pos, row + 1, col);
//            if (isPresent) return true;
//        }
//        board[row][col] = temp;
//        return false;
//    }
//}