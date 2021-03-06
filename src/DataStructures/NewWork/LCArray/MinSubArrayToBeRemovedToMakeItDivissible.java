package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;

public class MinSubArrayToBeRemovedToMakeItDivissible {
    public static void main(String[] args) {
        int[] arr = {5,2,4};
        System.out.println(new MinSubArrayToBeRemovedToMakeItDivissible().minSubarray(arr, 9));
    }

    public int minSubarray(int[] nums, int p) {
        int mod = 0, r_mod = 0, min_w = nums.length;
        for (var n : nums)
            mod = (mod + n) % p;
        if (mod == 0)
            return 0;
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            r_mod = (r_mod + nums[i]) % p;
            int comp = (p - mod + r_mod) % p;
            if (pos.containsKey(comp))
                min_w = Math.min(min_w, i - pos.get(comp));
            pos.put(r_mod, i);
        }
        return min_w >= nums.length ? -1 : min_w;
    }
}
