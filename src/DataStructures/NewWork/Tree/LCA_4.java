package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LCA_4 {
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
        TreeNode[] arr = {root.left.right.right, root.left.right.left};

        System.out.println(new LCA_4().lowestCommonAncestor(root, arr));
    }

    int total = 0;
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) return null;
        total = nodes.length;
        Set<Integer> set = new HashSet();
        for (TreeNode node : nodes) set.add(node.val);
        helper(root, set);
        return ans;
    }

    private void helper(TreeNode root, Set<Integer> set) {
        if (root == null) return;

        helper(root.left, set);
        helper(root.right, set);

        if (set.contains(root.val)) total--;

        if (total == 0 && ans == null) ans = root;
    }
}
