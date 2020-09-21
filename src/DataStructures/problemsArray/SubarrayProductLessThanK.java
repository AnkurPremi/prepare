package DataStructures.problemsArray;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6,122,111,10,12};
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(nums, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        int start = 0, end = 0;
        int count = 0;
        long productHere = 1;
        while(end < n) {
            productHere *= nums[end];
            while(productHere >= k && start <= end){
                productHere /= nums[start];
                start++;
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }
}
