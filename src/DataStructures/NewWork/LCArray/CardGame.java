package DataStructures.NewWork.LCArray;

public class CardGame {
    public static void main(String[] args) {
        int[] arr = {9,7,7,9,7,7,9};
        System.out.println(new CardGame().maxScore(arr, 7));
    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length - k;
        int l = 0, r = 0;
        int totalSum = 0, curSum = 0;
        int min = Integer.MAX_VALUE;

        while(r < cardPoints.length){
            totalSum += cardPoints[r];
            curSum += cardPoints[r];

            //if we have reached required window length..check the curSum min.. which will give right k elements maximum
            if(r-l+1 == n){
                min = Math.min(min, curSum);

                //remove the leftmost element from the window... which means include it in our answer..
                // means take 1 from left and k-1 from right
                curSum  = curSum - cardPoints[l];
                l++;
            }

            r++;
        }

        if(min == Integer.MAX_VALUE){
            return totalSum;
        } else{
            return totalSum - min;
        }
    }
}
