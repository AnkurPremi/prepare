package DataStructures.NewWork.DP;

public class StackBooksInShelves {
    public static void main(String[] args) {
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int width = 4;
        System.out.println(new StackBooksInShelves().minHeightShelves(books, width));
    }

    int[][] dp;
    public int minHeightShelves(int[][] books, int shelf_width) {
        dp = new int[books.length + 1][shelf_width + 1];
        return helper(books, 0, shelf_width, 0, 0);
    }

    private int helper(int[][] books, int i, int sw, int cw, int ch){
        if(i >= books.length) return ch;

        if(dp[i][cw] != 0) return dp[i][cw];
        int sameShelf = Integer.MAX_VALUE;
        if(cw + books[i][0] <= sw){
            sameShelf = helper(books, i+1, sw, cw + books[i][0],  Math.max(ch, books[i][1]));
        }

        int diffShelf = ch + helper(books, i+1, sw, books[i][0], books[i][1]);
        return dp[i][cw] = Math.min(diffShelf, sameShelf);
    }
}

