package DataStructures.NewWork.DP;

import java.util.HashMap;
import java.util.Map;

public class MaxNonOverlappingSubArrays {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        System.out.println(new MaxNonOverlappingSubArrays().maxNonOverlapping(arr, 2));
    }

    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int mi = -1;
        int sum = 0;
        for(int i = 0; i<nums.length ; i++){
            sum += nums[i];
            if(target - sum == 0){
                if(map.containsKey(target - sum)){
                    int idx = map.get(target - sum);
                    if(idx >= mi){
                        count++;
                        mi = idx;
                    }
                }
                map.put(sum, i);
            } else{
                if(map.containsKey(target - sum)){
                    int idx = map.get(target - sum);
                    if(idx >= mi){
                        count++;
                        mi = idx;
                    }
                }
                map.put(sum, i);
            }

        }
        return count;
    }
}
