package strings;

/**
 * 0 1 2 3 4 5
 * 1 0 0 0 0 0
 * 2 0 0 0 0 0
 * 3 0 0 0 0 0
 * 4 0 0 0 0 0
 * 5 0 0 0 0 0
 * 6 0 0 0 0 0
 * 7 0 0 0 0 0
 */
public class EditDistance {
    public static void main(String[] args) {
        String s = "ankur";
        String t = "anubhav";
        System.out.println(minDistance(s, t));
    }

    /**
     * when we move right means delete
     * move down means - insert
     * move diagonal means replace
     * first row and first column is for comparing characters with empty strings
     * if chars are same no operation is required, copy the number of operations done with previous chars of both string
     * if not same, then find out the minimum of the three operations (insert, delete, replace) and add 1 for the current
     * operation
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        if ((word1 == null || word1.isEmpty()) && (word2 == null || word2.isEmpty())) return 0;
        int[][] matrix = new int[word2.length() + 1][word1.length() + 1];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = i;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = i;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    int min = Math.min(matrix[i - 1][j - 1], matrix[i][j - 1]);
                    min = Math.min(min, matrix[i - 1][j]);
                    matrix[i][j] = min + 1;
                }
            }
        }
        return matrix[word2.length()][word1.length()];
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) System.out.println("\n");
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
