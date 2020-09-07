package LCTrees;

import Trees.SumLeftLeaves;
import Trees.TreeNode;

public class HasPathSum {
    public static void main(String[] args) {
        TreeNode node = SumLeftLeaves.createLargeBST();
        System.out.println(new HasPathSum().hasPathSum(node, 79));
    }

    boolean found = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum);
    }

    public boolean helper(TreeNode root, int sum){
        if(found) return true;
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(sum - root.val == 0) {
                found = true;
                return true;
            }
            return false;
        }
        return helper(root.left, sum-root.val) || helper(root.right, sum-root.val);
    }
}
