package misc;

import Trees.TreeNode;

import java.util.HashMap;
//https://leetcode.com/problems/house-robber-iii/
public class HouseRobberWithTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(1);
        HouseRobberWithTree robber = new HouseRobberWithTree();
        System.out.println(robber.robWithTree(node));

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(1);
        System.out.println(robber.robWithTree(root));

        root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        System.out.println(robber.robWithTree(root));
    }

    public int robTree(TreeNode root) {
        int prev1 = 0, prev2 = 0;
        System.out.println(robWithTree(root));
        return 0;
    }

    public int robWithTree(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        if (root.left != null) {
            val += robWithTree(root.left.left) + robWithTree(root.left.right);
        }
        if (root.right != null) {
            val += robWithTree(root.right.left) + robWithTree(root.right.right);
        }
        return Math.max(val + root.val, robWithTree(root.left) + robWithTree(root.right));
    }

    public int robWithTreeDP(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int val = 0;
        if (root.left != null) {
            val += robWithTreeDP(root.left.left, map) + robWithTreeDP(root.left.right, map);
        }
        if (root.right != null) {
            val += robWithTreeDP(root.right.left, map) + robWithTreeDP(root.right.right, map);
        }
        val = Math.max(val + root.val, robWithTreeDP(root.left, map) + robWithTreeDP(root.right, map));
        map.put(root, val);
        return val;
    }
}
