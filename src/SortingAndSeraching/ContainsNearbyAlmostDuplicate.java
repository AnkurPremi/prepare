package SortingAndSeraching;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3, t = 0;
    }

    //We will start traversing the array by checking the current element + t
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(checkIfMapHasAtMostValue(map, t, nums, i)){

            }
        }
        return false;
    }

    static boolean checkIfMapHasAtMostValue(Map<Integer, Integer> map, int t, int[] nums, int i){
        if(map.containsKey(nums[i]+t)){
            return true;
        }
        //do binary search
        int start = 0;
        int end = t;
        while(start < end){
            int mid = (start+end) >>1;
            if(map.containsKey(nums[i]+mid)){
                return true;
            }
        }

        return false;
    }
}
