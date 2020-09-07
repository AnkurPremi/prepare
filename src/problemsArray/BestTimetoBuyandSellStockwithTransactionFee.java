package problemsArray;

public class BestTimetoBuyandSellStockwithTransactionFee {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new BestTimetoBuyandSellStockwithTransactionFee().maxProfit(nums, fee));
    }

    public int maxProfit(int[] A, int fee) {
        int maxProfit = 0;
        if(A.length == 0) return maxProfit;
        int buyPrice = A[0];
        int prevProfit = 0;
        for(int i=1; i<A.length ;i++){
            int profitHere = Math.max(0, A[i] - buyPrice - fee);
            if(A[i] < buyPrice || profitHere < prevProfit){
                maxProfit += prevProfit;
                prevProfit = 0;
                buyPrice = A[i];
            } else if(prevProfit < profitHere){
                prevProfit = profitHere;
            }

        }
        return maxProfit + prevProfit;
    }
}
