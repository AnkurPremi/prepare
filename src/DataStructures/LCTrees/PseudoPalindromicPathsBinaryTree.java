package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

public class PseudoPalindromicPathsBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(1);
        node.right = new TreeNode(1);
        node.right.right = new TreeNode(1);
//        node.right.left = new TreeNode(0);
        System.out.println(new PseudoPalindromicPathsBinaryTree().pseudoPalindromicPaths(node));
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) return 0;
        int[] count = {0};
        helper(root, count, new int[9]);
        return count[0];
    }

    public void helper(TreeNode root, int[] count, int[] map){
        if(root == null) return;
        map[root.val-1]++;
        helper(root.left, count, map);
        helper(root.right, count, map);
        if(root.left == null && root.right == null && isPalindrome(map)){
            count[0]++;
        }
        map[root.val-1]--;
    }

    public boolean isPalindrome(int[] arr){
        boolean oneOdd = false;
        for(int i : arr){
            if(i%2 != 0){
                if(!oneOdd) oneOdd = true;
                else return false;
            }
        }
        return true;
    }
}
