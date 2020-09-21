package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(2);
        System.out.println(new MinimumDepthofBinaryTree().minDepth(node));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            depth++;
        }
        return depth;
    }
}
