package DataStructures.NewWork.LCArray;

public class RemoveDupsFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        System.out.println(new RemoveDupsFromSortedArray().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int l = 0, r = 1;
        while (r < n) {
            if (nums[l] == nums[r]) {
                l++;
            } else {
                while (r + 1 < n && nums[r] == nums[r + 1]) r++;
                nums[l] = nums[r];
                l++;

            }
            r++;
        }
        return l;
    }
}
