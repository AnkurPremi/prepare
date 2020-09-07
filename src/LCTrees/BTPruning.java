package LCTrees;

import Trees.TreeNode;

public class BTPruning {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(0);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(0);
        node.right = new TreeNode(1);
        node.right.right = new TreeNode(1);
        node.right.left = new TreeNode(0);
        TreeNode treeNode = new BTPruning().pruneTree(node);
        String s = "1001";

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);

        if (left == null) root.left = null;
        if (right == null) root.right = null;

        if (root.left == null && root.right == null) {
            if (root.val == 0) root = null;
        }
        return root;
    }
}
