package DataStructures.NewWork.LCArray;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {200000, 0, -2000000, -2};
        System.out.println(new MaxProductSubArray().maxProduct(arr));
    }

    public int maxProduct(int[] nums) {
        int minProduct = nums[0], maxProduct = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = minProduct;
                minProduct = maxProduct;
                maxProduct = temp;
            }

            minProduct = Math.min(nums[i], minProduct * nums[i]);
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);

            max = Math.max(max, maxProduct);

        }
        return max;
    }
}
