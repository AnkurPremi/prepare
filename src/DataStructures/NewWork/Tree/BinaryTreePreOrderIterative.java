package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreOrderIterative {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
}
