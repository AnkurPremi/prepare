package DataStructures.misc;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] arr1 = {10, 15, 20};
        int[] arr2 = {1, 0, 1, 0, 1, 0, 1, 0, 100, 1};
//        getCost(arr);
//        getCost(arr1);
        System.out.println(getMaxCost(arr));
        System.out.println(getMaxCost(arr1));
        System.out.println(getMaxCost(arr2));
    }

    static int getCost(int[] arr) {
        if (arr == null || arr.length < 2) return Integer.MIN_VALUE;
        int maxCost = 0;
        int i = 0;
        while (i < arr.length - 2) {
            if (arr[i + 2] > arr[i + 1]) {
                i += 1;
            } else {
                i += 2;
            }
            maxCost += arr[i];
        }
        if (i == arr.length - 1)
            maxCost += arr[arr.length - 1];

        return maxCost;
    }

    static int getMaxCost(int[] arr) {
        if (arr == null || arr.length < 2) return Integer.MIN_VALUE;

        for(int i=2; i<arr.length ; i++){
            arr[i] += Math.min(arr[i-2], arr[i-1]);//check if two jumps yields less cost or one jump-- add that to the previous cost
        }
        return Math.min(arr[arr.length-1], arr[arr.length-2]);
    }
}
