package LCTrees;

import Trees.SumLeftLeaves;
import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderReverse {
    public static void main(String[] args) {
        TreeNode node = SumLeftLeaves.createLargeBST();
        System.out.println(new LevelOrderReverse().levelOrderBottom(node));
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            int height = getMaxHeight(root);
            for (int i = 0 ; i < height; i++) {
                result.add(new ArrayList<Integer>());
            }
            helper(root, result, 1, height);
        }
        return result;
    }

    public void helper(TreeNode root, List<List<Integer>> result, int level, int height) {
        if (root == null) return;
        helper(root.left, result, level + 1, height);
        helper(root.right, result, level + 1, height);
        result.get(height - level ).add(root.val);
    }

    public int getMaxHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getMaxHeight(root.left), getMaxHeight(root.right)) + 1;
    }
}
