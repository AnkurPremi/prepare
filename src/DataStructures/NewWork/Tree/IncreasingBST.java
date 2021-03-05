package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

public class IncreasingBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root = new IncreasingBST().increasingBST(root);
        System.out.println("adasdasadad");
    }

    private TreeNode prev = null;
    private TreeNode head = null;

    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return head;
    }

    private void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);

        if(prev != null){
            prev.left = null;
            prev.right = root;
            root.left = null;
        }
        if(head == null) head = root;
        prev = root;

        helper(root.right);
    }
}
