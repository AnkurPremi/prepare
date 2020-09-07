package LCTrees;

import Trees.TreeNode;

public class CountGoodNodesinBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
//        node.left = new TreeNode(3);
//        node.left.left = new TreeNode(4);
//        node.left.right = new TreeNode(2);
        node.right = new TreeNode(4);
        node.right.right = new TreeNode(8);
        node.right.left = new TreeNode(10);
        node.right.right.left = new TreeNode(4);
        System.out.println(new CountGoodNodesinBinaryTree().goodNodes(node));
    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int[] maxcount = {1};
        helper(root.left, maxcount, root.val);
        helper(root.right, maxcount, root.val);
        return maxcount[0];
    }

    public void helper(TreeNode root, int[] maxcount, int maxhere) {
        if (root == null) return;

        if (root.val >= maxhere) {
            maxhere = root.val;
        }
        if (root.left == null && root.right == null) {
            maxcount[0]++;
        }

        helper(root.left, maxcount, maxhere);
        helper(root.right, maxcount, maxhere);
    }
}

