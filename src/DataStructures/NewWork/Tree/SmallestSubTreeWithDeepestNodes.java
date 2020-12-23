package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

public class SmallestSubTreeWithDeepestNodes {
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
        root = new SmallestSubTreeWithDeepestNodes().subtreeWithAllDeepest(root);

        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(2);
        node = new SmallestSubTreeWithDeepestNodes().subtreeWithAllDeepest(node);
    }

    TreeNode ans = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int[] max = {0};
        getSubTree(root, 1, max);
        return ans;
    }

    public int getSubTree(TreeNode root, int level, int[] max){
        if(root == null) return -1;

        int leftMax = getSubTree(root.left, level+1, max);
        int rightMax = getSubTree(root.right, level+1, max);

        if(leftMax >= max[0] && rightMax == leftMax){
            max[0] = leftMax;
            ans = root;
            return level;
        }

        if(level >= max[0]){
            ans = root;
            max[0] = level;
        }
        return level;
    }
}
