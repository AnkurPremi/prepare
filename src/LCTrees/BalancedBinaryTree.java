package LCTrees;

import Trees.SumLeftLeaves;
import Trees.TreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode node = SumLeftLeaves.createLargeBST();
        node.left.right.left.left = new TreeNode(299);
        node.left.right.left.left.left = new TreeNode(292);
        System.out.println(new BalancedBinaryTree().isBalanced(node));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null);
        boolean[] arr = new boolean[1];
        getHeight(root, arr);
        return !arr[0];
    }

    public int getHeight(TreeNode root, boolean[] found){
        if(root == null) return 0;
        if(found[0]) return -1;
        int left = getHeight(root.left, found);
        if(left == -1) return -1;
        int right = getHeight(root.right, found);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1){
            found[0] = true;
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
