package DataStructures.NewWork.LCArray;

public class Non_decreasingArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,3,4,3};
        System.out.println(new Non_decreasingArray().checkPossibility(arr));
    }

    public boolean checkPossibility(int[] nums) {
        boolean probable = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (!probable) return false;
                if (i - 1 == 0 || nums[i] - nums[i - 2] >= 0) {
                    probable = false;
                }
                else
                    return false;
            }
        }
        return true;
    }
}
