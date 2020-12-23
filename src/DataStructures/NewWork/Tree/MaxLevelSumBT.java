package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxLevelSumBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(989);
        root.right = new TreeNode(989);
//        root
    }

    public int maxLevelSum(TreeNode root) {
        int[] max = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        helper(root, max, new ArrayList(), 1);
        return max[0];
    }

    public void helper(TreeNode root, int[] max, List<Integer> sumList, int level) {
        if (root == null) return;

        if (sumList.size() < level) {
            sumList.add(root.val);
        } else {
            int val = sumList.get(level - 1);
            sumList.set(level - 1, val + root.val);
        }

        if (sumList.get(level - 1) > max[1]) {
            max[0] = level;
            max[1] = sumList.get(level - 1);
        } else if (sumList.get(level - 1) == max[1] && level < max[0]) {
            max[0] = level;
        }


        helper(root.left, max, sumList, level + 1);
        helper(root.right, max, sumList, level + 1);
    }
}
