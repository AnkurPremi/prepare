package DataStructures.NewWork.LCArray;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        new SortColors().sortColors(arr);
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        //bring 0's to the front
        int l = 0, r = 0;
        while (r < n) {
            if (nums[r] == 0) {
                nums[r] = nums[l];
                nums[l] = 0;
                l++;
            }
                r++;
        }

        //bring 2 to the right
        l = n - 1;
        r = n - 1;
        while (l >= 0) {
            if (nums[l] == 2) {
                nums[l] = nums[r];
                nums[r] = 2;
                r--;
            }
                l--;
        }
    }
}
