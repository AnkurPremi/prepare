package DataStructures.NewWork.DP;

public class SnakesAndLadders {
    public static void main(String[] args) {
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };
        System.out.println(new SnakesAndLadders().snakesAndLadders(board));
    }

    private static int INF = Integer.MAX_VALUE;

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        return helper(board, n - 1, n - 1, n);
    }

    private int helper(int[][] board, int x, int y, int n){
        if(x >= n && y >= n) return 0;
        if(x >= n || y >= n) return -1;

        int ans = INF;

        for(int i = 1 ; i <= 6 ; i++){
            int newX = i + x;
            int newY = y;
            if(i + x >= n) {
                newX = i + x - n - 1;
                newY = y + 1;
            }


            if(newX < n && newY < n && board[newX][newY] != -1){
                int moves = board[newX][newY];
                newX = moves / n;
                newY = moves % n;
            }

            int val = helper(board, newX, newY, n);
            if(val >= 0 && val < INF){
                ans = Math.min(ans, 1 + val);
            }
        }

        return ans;
    }
}


/**
 * class Solution {
 *     public int numSubmatrixSumTarget(int[][] matrix, int target) {
 *
 *         int ans = 0;
 *
 *         int m = matrix.length, n = matrix[0].length;
 *
 *         for(int i = 0 ; i < n ; i++){
 *
 *             int[] arr = new int[m];
 *
 *             for(int j = i ; j < n ; j++){
 *                 for(int k = 0 ; k < m ; k++){
 *                     arr[k] += matrix[k][j];
 *                 }
 *                 ans += subMatrixSum(arr, target);
 *                 System.out.println("ans-"+ans);
 *             }
 *         }
 *
 *         return ans;
 *     }
 *
 *     private int subMatrixSum(int[] arr, int target){
 *
 *         Map<Integer, Integer> map = new HashMap();
 *         int ans = 0;
 *         int sum = 0;
 *         // map.put(0, 1);
 *         for(int i = 0 ; i < arr.length ; i++){
 *             sum += arr[i];
 *             if(sum == target) ans++;
 *             if(map.containsKey(target - sum)){
 *                 ans += map.get(target - sum);
 *             }
 *             map.put(sum, map.getOrDefault(sum, 0) + 1);
 *         }
 *         return ans;
 *     }
 * }
 * **/