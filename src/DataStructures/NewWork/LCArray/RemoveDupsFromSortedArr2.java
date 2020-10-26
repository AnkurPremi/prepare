package DataStructures.NewWork.LCArray;

public class RemoveDupsFromSortedArr2 {
    public static void main(String[] args) {
//        int[] arr = {1,1,1,2,2,2,3,3,4,5,6};
        int[] arr = {1,2,2,2,2,3,4,5};
        System.out.println(new RemoveDupsFromSortedArr2().removeDuplicates(arr, 1));
    }

    public int removeDuplicates(int[] nums, int k) {
        int i = 0;
        for (int n : nums)
            if (i < k || n > nums[i-k])
                nums[i++] = n;
        return i;
    }
}
