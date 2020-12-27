package DataStructures.NewWork.Contest;

public class FairArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4};
        System.out.println(new FairArray().waysToMakeFair(arr));
    }
    

    /**
     * initially we sum the numbers at even index and odd index
     * then with the greedy approach we try to delete a index at even index and then at odd index
     * when we delete the number from even index..all the indices behind this index change their position
     * means odd indices become even and even become odd
     * all the left indices of an index change their position
     * and all the right indices remains same
     **/

    public int waysToMakeFair(int[] nums) {
        int allSumEven = 0, allSumOdd = 0;
        int leftSumEven = 0, leftSumOdd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                allSumEven += nums[i];
            } else {
                allSumOdd += nums[i];
            }
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i % 2 == 0) {
                allSumEven -= nums[i];
            } else {
                allSumOdd -= nums[i];
            }

            //check if the sum is fair sum
            if (leftSumEven + allSumOdd == leftSumOdd + allSumEven) {
                ans++;
            }

            //all the left even indices from this index will become odd from here and vice-versa
            if (i % 2 == 0) {
                leftSumEven += nums[i];
            } else {
                leftSumOdd += nums[i];
            }
        }

        return ans;
    }
}