package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

public class FlattenBTToLinkedList {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(6);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(7);
        node.right = new TreeNode(10);
        node.right.left = new TreeNode(100);
        node.right.left.left = new TreeNode(101);
        node.right.left.right = new TreeNode(102);
        node.right.right = new TreeNode(14);
        node.right.right.left = new TreeNode(13);
        new FlattenBTToLinkedList().flatten(node);
        System.out.println("adad");
    }

    TreeNode prev = null;
    public void flatten(TreeNode root){
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
