package DataStructures.NewWork.LCArray;

public class FirstMissingPositiveAgain {
    public static void main(String[] args) {
        int[] arr = {1,2,0};
        new FirstMissingPositiveAgain().firstMissingPositive(arr);
    }

    public int firstMissingPositive(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            max = Math.max(max, i);
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] <= 0)
                nums[i] = Integer.MAX_VALUE;
        }

        int idx = nums.length-1;

        for(int i=0;i<nums.length;i++){
            int tIdx = Math.abs(nums[i])-1;
            if(tIdx <= idx){
                if(nums[tIdx] > 0){
                    nums[tIdx] = -1*nums[tIdx];
                }
            }
        }
        int j=1;
        for(int i : nums){
            if(i>0) return j;
            j++;
        }
        return 0;
    }
}
