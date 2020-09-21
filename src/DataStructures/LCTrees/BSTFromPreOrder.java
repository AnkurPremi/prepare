package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.Stack;

public class BSTFromPreOrder {
    public static void main(String[] args) {
        int[] preorder = {8, 5, 3, 1, 4, 7, 10, 9, 12};
        TreeNode treeNode = new BSTFromPreOrder().bstFromPreorder1(preorder);
        System.out.println("check");
    }

    public TreeNode bstFromPreorder1(int[] preorder) {
        return helper(preorder, new int[]{0}, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] nums, int[] i, int bound) {
        //check if we have consumed the complete array or the current value is greater than the bound allowed
        if (i[0] == nums.length || nums[i[0]] > bound) return null;
        TreeNode node = new TreeNode(nums[i[0]++]);
        //all the elements in the left of this node should be smaller than the bound
        node.left = helper(nums, i, node.val);
        //for right nodes bound will still be the max value
        node.right = helper(nums, i, bound);
        return node;
    }


    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 1) return new TreeNode(preorder[0]);

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < n; i++) {
            TreeNode prev = null;
            TreeNode node = new TreeNode(preorder[i]);
            while (!stack.isEmpty() && stack.peek().val < preorder[i]) {
                prev = stack.pop();
            }
            if (prev != null) {
                prev.right = node;
            }

            if (!stack.isEmpty() && prev == null && preorder[i] < stack.peek().val) {
                stack.peek().left = node;
            }

            stack.push(node);
        }
        return root;
    }
}
