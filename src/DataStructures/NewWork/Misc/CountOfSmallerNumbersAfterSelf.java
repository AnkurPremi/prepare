package DataStructures.NewWork.Misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int[] arr = {-10, -5, 2, 6, 2};
        System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(arr));
    }


    /**
     * We can use Binary Indexed tree to store the information of elements smaller than itself on the right
     * search will be log(M) for each query
     * in total runtime will be Nlog(M) --> N length of the array ...M max value in the array
     * Total space - O(M)
     * <p>
     * Since we have negative numbers.. we will first convert the numbers to a positive range
     * after that .. we will search in Binary Index Tree
     **/
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList();
        int n = nums.length;
        if (n == 0) return result;

        // Mapping -ve integers to positive range - start
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - min + 1;
            max = Math.max(max, nums[i]);
        }
        // Mapping -ve integers to positive range - end


        int[] tree = new int[max + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(get(nums[i] - 1, tree)); // -1 because we don't want to count itself
            update(nums[i], tree);
        }
        Collections.reverse(result);
        return result;
    }

    private int get(int val, int[] tree) {
        int ans = 0;
        while (val > 0) {
            ans += tree[val];
            val -= val & (-val);
        }
        return ans;
    }

    private void update(int val, int[] tree) {
        while (val < tree.length) {
            tree[val]++;
            val += val & (-val);
        }
    }
}

