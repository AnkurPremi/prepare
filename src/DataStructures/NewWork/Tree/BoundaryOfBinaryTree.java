package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(15);
        node.left = new TreeNode(10);
        node.left.left = new TreeNode(8);
        node.left.left.left = new TreeNode(6);
        node.left.right = new TreeNode(12);
        node.left.right.left = new TreeNode(11);

        node.right = new TreeNode(20);
        node.right.left = new TreeNode(17);
        node.right.left.left = new TreeNode(16);
        node.right.right = new TreeNode(25);
        node.right.right.right = new TreeNode(27);

        System.out.println(new BoundaryOfBinaryTree().boundaryOfBinaryTree(node));
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> left = new ArrayList();
        left.add(root.val);
        helper(root.left, left, 1, true);

        List<Integer> right = new ArrayList();
        helper(root.right, right, 1, false);
        Collections.reverse(right);

        for (int i = 0; i < right.size(); i++) {
            left.add(right.get(i));
        }
        return left;
    }

    private void helper(TreeNode root, List<Integer> list, int level, boolean leftSide) {
        if (root == null) return;

        if (root.left == root.right) {
            list.add(root.val);
            return;
        }

        if (list.size() == level) {
            list.add(root.val);
        }
        if (leftSide) {
            helper(root.left, list, level + 1, leftSide);
            helper(root.right, list, level + 1, leftSide);
        } else {
            helper(root.right, list, level + 1, leftSide);
            helper(root.left, list, level + 1, leftSide);
        }
    }
}
