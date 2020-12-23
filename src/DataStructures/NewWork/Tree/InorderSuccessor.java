package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

public class InorderSuccessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root = new InorderSuccessor().inorderSuccessor(root, root);
        System.out.println("dasdd");
    }

    TreeNode prev = null;
    boolean found = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode[] ans = new TreeNode[1];
        helper(root, p, ans);
        return ans[0];
    }

    public void helper(TreeNode root, TreeNode p, TreeNode[] ans){
        if(root == null) return;

        helper(root.left, p, ans);

        if(root == p){
            prev = root;
        }
        else if(prev != null){
            ans[0] = root;
            prev = null;
        }


        helper(root.right, p, ans);
    }
}
