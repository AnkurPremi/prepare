package DataStructures.LCTrees;

import DataStructures.Trees.SumLeftLeaves;
import DataStructures.Trees.TreeNode;

public class MinAbsDiffBST {
    public static void main(String[] args) {
        TreeNode node = SumLeftLeaves.createLargeBST();
        System.out.println(new MinAbsDiffBST().getMinimumDifference(node));
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        int[] minDiff = new int[1];
        minDiff[0] = Integer.MAX_VALUE;
        TreeNode[] prev = new TreeNode[1];
        helper(root, prev, minDiff);
        return minDiff[0];
    }

    public void helper(TreeNode root, TreeNode[] prev, int[] minDiff) {
        if (root == null) return;

        helper(root.left, prev, minDiff);

        if (prev[0] == null) {
            prev[0] = root;
        } else {
            minDiff[0] = Math.min(minDiff[0], Math.abs(root.val - prev[0].val));
            prev[0] = root;
        }

        helper(root.right, prev, minDiff);
    }
}
