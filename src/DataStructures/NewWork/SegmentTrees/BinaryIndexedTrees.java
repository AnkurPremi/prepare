package DataStructures.NewWork.SegmentTrees;

import java.util.Arrays;

public class BinaryIndexedTrees {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        NumArray numArray = new NumArray(arr);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 5);
        System.out.println(Arrays.toString(arr));
        System.out.println(numArray.sumRange(0, 2));
    }
}

class NumArray {
    int[] tree;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            updateTree(i + 1, nums[i]);
        }
    }


    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        updateTree(i + 1, delta);
    }

    private void updateTree(int i, int val) {
        while (i < tree.length) {
            tree[i] += val;
            i += (i & -i);
        }
    }

    public int sumRange(int i, int j) {
        return get(j + 1) - get(i);
    }

    private int get(int i) {
        int ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= (i & -i);
        }
        return ans;
    }

}