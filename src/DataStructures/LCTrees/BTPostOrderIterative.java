package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPostOrderIterative {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(6);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(7);
        node.right = new TreeNode(10);
        node.right.right = new TreeNode(14);
        node.right.right.left = new TreeNode(13);
        System.out.println(new BTPostOrderIterative().postorderTraversal(node));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root.left != null || root.right != null) {
                if (root.right != null){
                    stack.push(root.left);
                }
                if(root.left != null) {
                    stack.push(root.left);
                    root = root.left;
                }
            }
            TreeNode node = stack.pop();
            list.add(node.val);
        }
        return list;
    }
}
