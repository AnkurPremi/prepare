package LCTrees;

import Trees.TreeNode;

public class DistributeCoins {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(0);
//        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(1);
        node.right = new TreeNode(0);
//        node.right.right = new TreeNode(1);
//        node.right.left = new TreeNode(0);
        new DistributeCoins().distributeCoins(node);
    }
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}
