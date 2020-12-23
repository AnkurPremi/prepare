package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

public class TreeToCircularDLL {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root = new TreeToCircularDLL().treeToDoublyList(root);
    }

    TreeNode head = null, tail = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        helper(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);

        if(head == null)
            head = root;

        if(tail != null){
            if(root.left == tail)
                tail.right = root;
            else if(tail.right == root)
                root.left = tail;
            else {
                root.left = tail;
                tail.right = root;
            }
        }

        tail = root;

        helper(root.right);
    }
}
