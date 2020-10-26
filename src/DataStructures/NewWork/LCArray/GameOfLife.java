package DataStructures.NewWork.LCArray;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new GameOfLife().gameOfLife(board);
    }

    public void gameOfLife(int[][] board) {
        int[] dir = {-1, 0, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                playGame(board, i, j, dir);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public void playGame(int[][] board, int i, int j, int[] dir) {
        int countLives = 0;
        for (int dx : dir) {
            for (int dy : dir) {
                if (dx == 0 && dy == 0) continue;
                if (i + dx < 0 || i + dx > board.length - 1 || j + dy < 0 || j + dy > board[0].length - 1) continue;
                if ((board[i + dx][j + dy] & 1) == 1)
                    countLives++;
            }
        }

        if ((board[i][j] & 1) == 1) {
            if (countLives == 2 || countLives == 3) {
                board[i][j] = 3;
            } else {
                board[i][j] = 1;
            }
        } else {
            if (countLives == 3) {
                board[i][j] = 2;
            }
        }
    }
}
