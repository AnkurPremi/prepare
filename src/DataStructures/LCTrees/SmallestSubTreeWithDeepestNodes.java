package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

public class SmallestSubTreeWithDeepestNodes {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(6);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(7);
        node.right = new TreeNode(10);
        node.right.right = new TreeNode(14);
        node.right.left = new TreeNode(13);
        node.right.left.left = new TreeNode(16);
        node.right.left.right = new TreeNode(17);
        System.out.println(new SmallestSubTreeWithDeepestNodes().subtreeWithAllDeepest(node));
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode[] max = new TreeNode[1];
        helper(root, max, 1, new int[]{Integer.MIN_VALUE});
        return max[0];
    }

    public int helper(TreeNode root, TreeNode[] max, int level, int[] levelMax) {
        if (root == null) return 0;
        int left = helper(root.left, max, level + 1, levelMax);
        int right = helper(root.right, max, level + 1, levelMax);

        if (left == right && left >= levelMax[0]) {
            max[0] = root;
            levelMax[0] = left;
        }

        if(left > right) return left;
        else if(right > left) return right;
        return level;
    }

}
