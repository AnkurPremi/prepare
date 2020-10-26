package DataStructures.HashTable;

import java.util.HashMap;
import java.util.Map;

public class AlphabetBoardpath {
    public static void main(String[] args) {
        String target = "zdz";
        System.out.println(new AlphabetBoardpath().alphabetBoardPath(target));
    }

    public String alphabetBoardPath(String target) {
        return searchAndAppend(target);
    }

    public String searchAndAppend(String target) {
        StringBuilder builder = new StringBuilder();
        int row = 0;
        int col = 0;
        for (char c : target.toCharArray()) {
            int x = (c - 'a') / 5;
            int y = (c - 'a') % 5;
            while (y < col) {
                builder.append('L');
                col--;
            }
            while (x > row) {
                builder.append('D');
                row++;
            }
            while (x < row) {
                builder.append('U');
                row--;
            }

            while (y > col) {
                builder.append('R');
                col++;
            }

            builder.append('!');
        }
        return builder.toString();
    }
}
