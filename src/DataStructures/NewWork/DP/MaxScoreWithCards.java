package DataStructures.NewWork.DP;

public class MaxScoreWithCards {
    public static void main(String[] args) {

    }

    public int maxScore(int[] cardPoints, int k) {
        int[] max = {0};
        helper(cardPoints, k, max, 0, cardPoints.length-1, 0);
        return max[0];
    }

    private void helper(int[] arr, int k, int[] max, int start, int end, int sum){
        if(start > end) return;

        if(k == 0){
            max[0] = Math.max(max[0], sum);
            return;
        }

        helper(arr, k - 1, max, start+1, end, sum + arr[start]);
        helper(arr, k - 1, max, start, end - 1, sum + arr[end]);

    }
}
