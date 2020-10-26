package DataStructures.NewWork.LCArray;

public class LongestSubArrayWith1sAfterDelete {
    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1,1,1,0,1};
        System.out.println(new LongestSubArrayWith1sAfterDelete().longestSubarray(arr));
    }

    public int longestSubarray(int[] nums) {
        int b4Del = 0;
        int afDel = 0;
        boolean isDeleted = false;
        int i=0;
        int max = 0;
        while(i < nums.length && nums[i] == 0) i++;
        for(; i<nums.length ; i++){
            if(!isDeleted){
                if(nums[i] == 0)
                    isDeleted = true;
                else
                    b4Del++;
            }else{
                if(nums[i] == 0){
                    max = Math.max(max, b4Del+afDel);
                    b4Del = afDel;
                    afDel = 0;
                }else{
                    afDel++;
                }
            }
        }
        return Math.max(max, b4Del+afDel);
    }
}
