package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrder {
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
        System.out.println(new ZigZagLevelOrder().zigzagLevelOrder(node));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, TreeNode root, int level){
        if(root == null) return;

        if(level == result.size())
            result.add(new LinkedList());

        if(level % 2 == 0){
            LinkedList<Integer> list = (LinkedList<Integer>) result.get(level);
            list.addLast(root.val);
        } else{
            LinkedList<Integer> list = (LinkedList<Integer>) result.get(level);
            list.addFirst(root.val);
        }

        helper(result, root.left, level+1);
        helper(result, root.right, level+1);
    }
}
