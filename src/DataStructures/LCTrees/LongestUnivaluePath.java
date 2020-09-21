package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

public class LongestUnivaluePath {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(1);
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(node));
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int[] max = new int[1];
        int[] count = new int[1];
        Integer[] prev = new Integer[1];
        helper(root, max, prev, count);
        return Math.max(max[0], count[0]) - 1;
    }

    public void helper(TreeNode root, int[] max, Integer[] prev, int[] count) {
        if (root == null) return;
        helper(root.left, max, prev, count);
        if (prev[0] == null) {
            prev[0] = root.val;
            count[0]++;
        } else if (prev[0] != root.val) {
            max[0] = Math.max(max[0], count[0]);
            count[0] = 1;
            prev[0] = root.val;
        } else {
            count[0]++;
        }
        helper(root.right, max, prev, count);
    }
}
