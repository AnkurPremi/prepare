package Arrays;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicatesfromSortedArray().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast] > nums[slow]){
                nums[slow+1] = nums[fast];
                slow += 1;
            }
            fast++;
        }
        return slow == nums.length-1 ? slow : slow+1;
    }
}
