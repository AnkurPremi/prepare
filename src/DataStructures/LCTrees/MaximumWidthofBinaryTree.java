package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthofBinaryTree {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(6);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(7);
        node.right = new TreeNode(10);
        node.right.right = new TreeNode(14);
        node.right.right.left = new TreeNode(13);
        System.out.println(new MaximumWidthofBinaryTree().widthOfBinaryTree(node));
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0, temp = 0;
            while (size > 0) {
                size--;
                TreeNode node = queue.poll();
                if (node == null) {
                    if (start == 1) temp++;
                    continue;
                }
                if (node != null && start == 0) {
                    start = 1;
                    end = 1;
                }
                else if (node != null && start == 1) {
                    end = temp + end + 1;
                    temp = 0;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            max = Math.max(max, end == 0? start : end);
        }
        return max;
    }
}
