package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

public class LargestBSTInSubTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(4);
        System.out.println(new LargestBSTInSubTree().maxSumBST(root));

    }

    public int maxSumBST(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        findMaxSum(root, max);
        return max[0];
    }

    private int[] findMaxSum(TreeNode root, int[] max){
        if(root == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = findMaxSum(root.left, max);
        int[] right = findMaxSum(root.right, max);

        if(left[0] == 0 && right[0] == 0){

            //greater than biggest in left  &  smaller than smallest in right
            if(root.val > left[2] && root.val < right[1]){
                left[1] = Math.min(root.val, left[1]);
                left[2] = Math.max(root.val, right[2]);
                int sum = root.val + left[3] + right[3];
                left[3] = sum;
                max[0] = Math.max(max[0], sum);
            } else {
                left[0] = 1;
            }
        } else {
            left[0] = 1;
        }

        return left;
    }

    public int maxSumBST1(TreeNode root) {
        int[] max = {0};
        postorder(root, max);
        return max[0];
    }

    private int[] postorder(TreeNode root, int[] max){
        if(root == null)
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // sum, min, max, isBST

        int[] left = postorder(root.left, max);
        int[] right = postorder(root.right, max);

        //left and right are BSTs         //check if along with root..do they make a BST
        if(left[3] == 0 && right[3] == 0 && root.val > left[2] && root.val < right[1]){
            int sum = left[0] + right[0] + root.val;
            max[0] = Math.max(max[0], sum);
            return new int[]{sum, Math.min(left[1], root.val), Math.max(right[2], root.val), 0};
        } else{
            return new int[]{0, 0, 0, 1};
        }
    }

}
