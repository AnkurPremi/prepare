package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewBT {
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
        System.out.println(new RightSideViewBT().rightSideView1(node));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 1) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return result;
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, result, 0);
        return result;
    }
    public void helper(TreeNode root, List<Integer> list, int level){
        if(root == null) return;
        if(list.size() == level){
            list.add(root.val);
        }
        helper(root.right, list, level+1);
        helper(root.left, list, level+1);
    }
}
