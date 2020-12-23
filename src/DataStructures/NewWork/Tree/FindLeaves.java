package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLeaves {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(15);
        node.left = new TreeNode(10);
        node.left.left = new TreeNode(8);
        node.left.left.left = new TreeNode(6);
        node.left.right = new TreeNode(12);
        node.left.right.left = new TreeNode(11);

        node.right = new TreeNode(20);
        node.right.left = new TreeNode(17);
        node.right.left.left = new TreeNode(16);
        node.right.right = new TreeNode(25);
        node.right.right.right = new TreeNode(27);
        System.out.println(new FindLeaves().findLeaves(node));
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) return new ArrayList();
        List<List<Integer>> result = new ArrayList();

        List<List<Integer>> left = findLeaves(root.left);
        List<List<Integer>> right = findLeaves(root.right);
        int i=0, j=0;
        while(i<left.size() || j<right.size()){
            List<Integer> list = new ArrayList();

            if(i<left.size()){
                list.addAll(left.get(i++));
            }

            if(j<right.size()){
                list.addAll(right.get(j++));
            }
            result.add(list);
        }

        result.add(new ArrayList(Arrays.asList(root.val)));


        return result;
    }
}
