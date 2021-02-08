package DataStructures.NewWork.LCArray;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3};
        nums = new SlidingWindowMaximum().maxSlidingWindow(nums, 2);
        System.out.println("adasdad");
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length * k == 0 || nums.length == 1) {
            return nums;
        }
        //[1,3,-1,-3,5,3], k = 2;
        //left: [1, 0, 0, 0, 0, 0]
        //right: [0,0,0,0,0,3];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        //left: [1,3,-1,-1,5,5];
        for (int i = 1; i < nums.length; i++) {
            if (i % k == 0)  {// first element of each window, which stands side by side
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
        }
        //right: [1,3,-1,5,5,3]
        for (int i = nums.length-2; i >= 0; i--) {
            if (i % k == 0) {
                right[i] = nums[i];
            } else {
                right[i] = Math.max(right[i + 1], nums[i]);
            }
        }
        int[] res = new int[nums.length - k + 1];
        //res:[3,3,-1,5,5];
        for (int i = 0; i < nums.length - k + 1; i++) {// res.length = nums.length-k+1
            // right's first vs. left's last;
            res[i] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }
}
