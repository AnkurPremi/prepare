package DataStructures.NewWork.LCArray;

public class KthMissingInSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,7,9,10};
        System.out.println(new KthMissingInSortedArray().missingElement(arr, 3));
    }

    public int missingElement(int[] nums, int k) {

        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] + 1 == nums[i-1]) continue;

            if(nums[i] - nums[i - 1] - 1 < k){
                k -= nums[i] - nums[i - 1] - 1;
            } else if(nums[i] - nums[i - 1] - 1 >= k){
                return nums[i - 1] + k;
            }
        }
        return nums[nums.length - 1] + k;
    }
}
