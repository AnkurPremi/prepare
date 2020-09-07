package LCTrees;

import Trees.SumLeftLeaves;
import Trees.TreeNode;

public class BinaryTreeTilt {
    public static void main(String[] args) {
        TreeNode node = SumLeftLeaves.createLargeBST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new BinaryTreeTilt().findTilt(root));
    }

    public int findTilt(TreeNode root) {
        int[] tilt = new int[1];
        helper(root, tilt);
        return tilt[0];
    }

    public int helper(TreeNode root, int[] tilt) {
        if (root == null) return 0;

        int leftSum = helper(root.left, tilt);
        int rightSum = helper(root.right, tilt);

        tilt[0] += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + root.val;
    }
}
