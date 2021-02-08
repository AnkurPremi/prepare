package DataStructures.NewWork.LCArray;

public class SmallerThanCurrent {
    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};
        System.out.println(new SmallerThanCurrent().smallerNumbersThanCurrent(arr));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[101];

        for(int num : nums){
            counts[num]++;
        }

        int[] smaller = new int[counts.length];
        int small = counts[0];
        for(int i=1; i<counts.length ; i++){

            smaller[i] = small;
            small += counts[i];
        }

        int[] ans = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++){
            ans[i] = smaller[nums[i]];
        }

        return ans;
    }
}
