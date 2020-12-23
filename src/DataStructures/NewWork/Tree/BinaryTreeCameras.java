package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

public class BinaryTreeCameras {
    public static void main(String[] args) {

    }

    int res = 0;
    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;//placed camera and informing parent by returning 1
            return 1;
        }

//        if(root.left == root.right)
//            return 0;
        if(left == 1 || right == 1)
            return 2;

        return 0;
    }
}
