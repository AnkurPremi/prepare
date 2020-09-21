package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorderIterative {
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
        System.out.println(new BTInorderIterative().inorderTraversal(node));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            while(root.left != null){
                stack.push(root.left);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null){
                node = node.right;
                stack.push(node);
                while(node.left != null){
                    stack.push(node.left);
                    node = node.left;
                }
            }
        }
        return list;
    }
}
