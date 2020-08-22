package misc;

class NumArray {
    int[] runningSumArr;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        runningSumArr = new int[nums.length];
        runningSumArr[0] = nums[0];
        for(int i=1 ; i< nums.length ;i++){
            runningSumArr[i] = nums[i] + runningSumArr[i-1];
        }
    }

    public int sumRange(int i, int j) {
        //if both i and j are in limits
        return runningSumArr[j] - runningSumArr[i] + nums[i];
    }
}

public class MyClass{
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}