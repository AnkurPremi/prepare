package DataStructures.NewWork.LCArray;

public class NumbersSmaller {
    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};
        new NumbersSmaller().smallerNumbersThanCurrent(arr);
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[502];
        int max = -1;
        for(int i=0; i< nums.length ; i++){
            max = Math.max(max, nums[i]);
            arr[nums[i]+1]++;
        }

        //find the increasing sum of the previous numbers count in the array
        for(int i=1; i<max+1 ; i++){
            arr[i] = arr[i] + arr[i-1];
        }

        for(int i = 0; i<nums.length ; i++){
            nums[i] = arr[nums[i]];
        }
        return nums;
    }
}
