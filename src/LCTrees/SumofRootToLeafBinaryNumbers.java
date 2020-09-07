package LCTrees;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumofRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(new SumofRootToLeafBinaryNumbers().sumRootToLeaf(root));
    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        int[] result = new int[1];
        helper(root, "", result);
        return result[0];
    }

    public void helper(TreeNode root, String s, int[] result) {
        if (root.left == null && root.right == null) {
            result[0] += Integer.parseInt(s + root.val, 2);
            return;
        }
        helper(root.left, s + root.val, result);
        helper(root.right, s + root.val, result);
    }
}
