package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode node = new SortedArrayToBST().sortedArrayToBST(nums);
        System.out.println("sad");
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if(n == 0) return null;
        return helper(nums, 0, n-1);
    }

    public TreeNode helper(int[] nums, int start, int end){
        if(start > end) return null;
        int mid = (start+end)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}
