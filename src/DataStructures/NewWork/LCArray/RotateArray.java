package DataStructures.NewWork.LCArray;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        new RotateArray().rotate(arr, 5);
    }

    public void rotate(int[] nums, int k) {
        if(k == 0) return;

        int n = nums.length;

        k = k % n;

        //rotate left half
        int l = 0, r = n - k - 1;
        while(l <= r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        //rotate right half
        l = n - k; r = n - 1;
        while(l <= r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        //swap elements in 2 halves
        l = k - 1 ; r = n - k;
        while(l >= 0 && r < n){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l--;
            r++;
        }
    }
}
