package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalancedBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(3);
        node.right.right.right = new TreeNode(4);
        node.right.right.right.right = new TreeNode(5);
        node.right.right.right.right.right = new TreeNode(6);
        System.out.println(new BalancedBST().balanceBST(node));
    }

    public TreeNode balanceBST(TreeNode root) {
        if(root == null) return null;
        List<Integer> list = new ArrayList();
        helper(root, list);
        return createTree(list, list.size());
    }

    int idx = 0;
    private TreeNode createTree(List<Integer> list, int count){
        if(count <= 0 || idx >= list.size()) return null;
        TreeNode left = createTree(list, count/2);
        TreeNode root = new TreeNode(list.get(idx++));
        root.left = left;
        root.right = createTree(list, count - count/2 - 1);
        return root;
    }

    private void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
