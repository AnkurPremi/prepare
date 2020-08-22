package Trees;

import java.util.LinkedList;
import java.util.Stack;

public class Traversel_Iterative {
    public static void main(String[] args) {
        TreeNode root = ValidateBST.createBST();
//        inOrder(root);
//        preOrder(root);
        postOrder(root);
    }

    static void inOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.println(temp.val);
            temp = temp.right;
        }
    }

    static void preOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null ) {
            System.out.println(temp.val);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
            temp =  stack.isEmpty() ? null : stack.pop();
        }
    }

    static void postOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()){
            while(temp != null){
                stack.push(temp);
                temp = temp.right;
            }
            temp = stack.pop();
            if(temp.left != null && temp.right != null){
                temp = temp.left;
                while(temp != null){
                    stack.push(temp);
                    temp = temp.right;
                }
            }else{
                System.out.println(temp.val);
                temp = stack.peek().left;
            }
        }
    }
}
