package DataStructures.DP;

import java.util.Arrays;
import java.util.LinkedList;

//a diff version of house robber
public class MaxDeleteAndEarn {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        System.out.println(new MaxDeleteAndEarn().deleteAndEarn(arr));
        LinkedList<Integer>[] table = new LinkedList[4];
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int max1 = 0;
        int max2 = 0;
        for(int i : nums){
            int temp = max2;
            max2 = Math.max(max1 + i, max2);
            max1 = temp;
        }
        return Math.max(max1, max2);
    }
}
