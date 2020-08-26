package Arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, -2, -3, -5, 7};
        System.out.println(maxProduct1(nums));
    }

    public static int maxProduct1(int[] nums) {
        if (nums.length == 0) return 0;
        //here negative numbers if are odd in count then they will divide the array nums into two
        //to handle that.. we will go from start to end..checking the product
        //and we will go from end to start
        int product = 1;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            product = product * i;
            max = Math.max(product, max);
            if (product == 0) product = 1;
        }
        product=1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product = product * i;
            max = Math.max(product, max);
            if (product == 0) product = 1;
        }
        return max;
    }
}