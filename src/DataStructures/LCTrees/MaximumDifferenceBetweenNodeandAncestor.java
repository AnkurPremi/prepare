package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

public class MaximumDifferenceBetweenNodeandAncestor {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(6);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(7);
        node.right = new TreeNode(10);
        node.right.right = new TreeNode(14);
        node.right.right.left = new TreeNode(13);
        System.out.println(new MaximumDifferenceBetweenNodeandAncestor().maxAncestorDiff(node));
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        int[] max = {0};
        helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE, max);
        return max[0];
    }

    public void helper(TreeNode root, int minVal, int maxVal, int[] max) {
        if (root == null) return;

        minVal = Math.min(minVal, root.val);
        maxVal = Math.max(maxVal, root.val);

        if (root.left == null && root.right == null) {
            max[0] = Math.max(max[0], Math.abs(maxVal - minVal));
        }

        helper(root.left, minVal, maxVal, max);
        helper(root.right, minVal, maxVal, max);
    }
}
