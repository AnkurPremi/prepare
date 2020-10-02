package DataStructures.HashTable;

import java.util.HashSet;
import java.util.Set;

public class ContainsDups2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3};
        System.out.println(new ContainsDups2().containsNearbyDuplicate(arr, 2));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< nums.length; i++){
            //In order to maintain the requirement, we will check for the duplicate in range only (within k)
            //If we are going beyond range, remove the element from the set
            if(!set.add(nums[i]))
                return true;
            if(i >= k){
                set.remove(nums[i-k]);
            }
        }
        //If all the elements get added to the set that means there are no duplicates
        return false;
    }
}
