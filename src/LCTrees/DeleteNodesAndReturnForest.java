package LCTrees;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        List<TreeNode> list = new DeleteNodesAndReturnForest().delNodes(node, new int[]{3,5});
        System.out.println("adasdads");
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(root == null) return result;
        Set<Integer> set = new HashSet<>();
        for(int val : to_delete){
            set.add(val);
        }
        helper(root, set, result);
        return result;
    }

    public void helper(TreeNode root, Set<Integer> set, List<TreeNode> result){
        if(root == null) return;
        helper(root.left, set, result);
        helper(root.right, set, result);

        if(set.contains(root.val)){
            if(root.left != null){
                result.add(root.left);
            }
            if(root.right != null){
                result.add(root.right);
            }
            set.remove(root.val);
            root = null;
        }
    }
}
