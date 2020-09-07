package problemsArray;

//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class ShortesrUsortedCOntArray {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4,5};
        System.out.println(new ShortesrUsortedCOntArray().findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        if(nums == null) return 0;
        int len = nums.length;
        if(len <2) return 0;

        //here start = -2 and end = -1..because if there the array doesn't have any issue..
        //then return will be 0

        //move from start to find the number out of position
        int max = Integer.MIN_VALUE;
        int start = -2;
        for(int i=0; i< len;i++){
            max = Math.max(max, nums[i]);
            //this is to compare the last number which is smaller than max
            //this will give you the actual index where the number out of position should be
            if(nums[i] < max){
                start = i;
            }
        }

        //move from end to find the number out of position
        int min = Integer.MAX_VALUE;
        int end = -1;
        for(int i=len-1 ; i>=0 ; i--){
            min = Math.min(min, nums[i]);
            //this is to compare the last number which is greater than min
            //this will give you the actual index where the number out of position should be
            if(nums[i] > min){
                end = i;
            }
        }

        return start - end + 1;
    }

}
