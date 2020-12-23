package DataStructures.NewWork.DP;

public class MaxSumDivisibleBy3 {
    public static void main(String[] args) {
        int[] arr = {2,6,2,2,7};
        System.out.println(new MaxSumDivisibleBy3().maxSumDivThree(arr));
    }

    public int maxSumDivThree(int[] nums) {

        int min1 = 10001, min2 = 10001, min3 = 10001, min4 = 10001;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (num % 3 == 1) {
                if (num <= min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }
            } else if (num % 3 == 2) {
                if (num <= min3) {
                    min4 = min3;
                    min3 = num;
                } else if (num < min4) {
                    min4 = num;
                }
            }
        }

        if (sum % 3 == 0) return sum;

        int min = 10001;

        if (sum % 3 == 1) {
            if (min1 != 10001)
                min = Math.min(min1, min);
            if (min3 != 10001 && min4 != 10001)
                min = Math.min(min, min3 + min4);

            return sum - min;

        } else {
            if (min3 != 10001)
                min = Math.min(min3, min);
            if (min1 != 10001 && min2 != 10001)
                min = Math.min(min, min1 + min2);

            return sum - min;

        }

    }
}
