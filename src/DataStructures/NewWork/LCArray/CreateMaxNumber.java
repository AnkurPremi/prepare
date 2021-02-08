package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.List;

public class CreateMaxNumber {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        nums1 = new CreateMaxNumber().maxNumber(nums1, nums2, 5);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        List<Integer> ans = new ArrayList();
        maxNumberOfSingleArray(nums2, k);
        helper(nums1, nums2, k, 0, 0, ans, new ArrayList());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private int[] maxNumberOfSingleArray(int[] nums, int k){
        int[] result = new int[k];
        if(k == 0) return result;

        int len = nums.length;
        int idx = 0;
        for(int i = 0; i < len; i++){
            while((len-i-1) + (idx+1) > k && idx>0 && nums[i] > result[idx-1]) idx--;
            if(idx < k) result[idx++] = nums[i];
        }
        return result;
    }

    private void helper(int[] nums1, int[] nums2, int k, int i, int j, List<Integer> ans, List<Integer> list) {
        if (k == 0) {
            if (greater(ans, list)) {
                ans = new ArrayList(list);
                System.out.println(ans);
            }
            return;
        }

        if (i == nums1.length && j == nums2.length) return;


        if (i < nums1.length) {
            //pick from 1st
            list.add(nums1[i]);
            helper(nums1, nums2, k - 1, i + 1, j, ans, list);
            list.remove(list.size() - 1);

            //leave 1st
            helper(nums1, nums2, k, i + 1, j, ans, list);
        }

        if (j < nums2.length) {
            //pick from 2nd
            list.add(nums2[j]);
            helper(nums1, nums2, k - 1, i, j + 1, ans, list);
            list.remove(list.size() - 1);

            //leave 2nd
            helper(nums1, nums2, k, i, j + 1, ans, list);
        }

    }

    private boolean greater(List<Integer> ans, List<Integer> list) {

        for (int i = 0; i < ans.size(); i++) {
            if (list.get(i) < ans.get(i)) return false;
        }

        return true;
    }
}
