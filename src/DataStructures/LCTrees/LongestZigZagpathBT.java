package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

public class LongestZigZagpathBT {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(10);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(6);
        node.right.right.right = new TreeNode(6);
        node.right.right.left = new TreeNode(4);
        node.right.right.left.right = new TreeNode(4);
        node.right.right.left.right.right = new TreeNode(4);
//        node.right = new TreeNode(10);
//        node.right.right = new TreeNode(14);
//        node.right.left = new TreeNode(13);
        System.out.println(new LongestZigZagpathBT().longestZigZag(node));
    }

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        int[] max = {0};
        helper(root.left, max, false, 1);
        helper(root.right, max, true, 1);
        return max[0];
    }

    public void helper(TreeNode root, int[] max, boolean button, int count) {
        if (root == null) return;
        if(root.left !=null)
            helper(root.left, max, false, button ? count + 1 : 1);
        if(root.right != null)
            helper(root.right, max, true, !button ? count + 1 : 1);

        //one more solution
//        if(button){
//            helper(root.left, max, false, count + 1);
//            helper(root.right, max, true, 1);
//        } else{
//            helper(root.right, max, true, count + 1);
//            helper(root.left, max, false, 1);
//        }
        max[0] = Math.max(max[0], count);

    }
}