package misc;

public class MaxProfit {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(getMaxProfit(arr));
        int[] arr1 = {7, 6, 5, 4, 3, 2, 1};
        System.out.println(getMaxProfit(arr1));
        int[] arr2 = {7, 4, 1, 5, 3, 8, 20};
        System.out.println(getMaxProfit(arr2));
    }

    static int getMaxProfit(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int maxProfit = 0;
        int profitNow = 0;
        int i = 0;
        int j = 1;
        while (j < arr.length) {
            if (arr[j] < arr[i]) i = j;
            profitNow = arr[j] - arr[i];
            maxProfit = profitNow > maxProfit ? profitNow : maxProfit;
            j++;
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }
}
