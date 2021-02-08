package DataStructures.NewWork.LCArray;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {-1,1,3,4,2,1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
    //-1,1,3,4,2,7
    public int firstMissingPositive(int[] nums){
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            while(nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }

        return n + 1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
