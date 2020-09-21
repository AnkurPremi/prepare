package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.Stack;

public class BTFromPreAndPostOrder {
    public static void main(String[] args) {
        TreeNode node = new BTFromPreAndPostOrder().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        System.out.println("adasda");
    }

    public TreeNode treeFromPreAndPost(int[] pre, int[] post) {
        return helper(pre, post, new int[1], new int[1]);
    }

    public TreeNode helper(int[] pre, int[] post, int[] i, int[] j) {
        TreeNode root = new TreeNode(pre[i[0]++]);
        if (root.val != post[j[0]]) {
            root.left = helper(pre, post, i, j);
        }
        if (root.val != post[j[0]]) {
            root.right = helper(pre, post, i, j);
        }
        j[0]++;
        return root;
    }

    //when we are traversing post and checking post[i]....that means we have already visited sub tree of post
    //here in the solution..we will construct the tree from pre and verify it with post..
    //we will check if we find any value same as post...the subtree corresponding to that node is already created..and we can remove the node from the stack.
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(pre[0]);
        stack.push(root);
        int postIdx = 0;
        for (int preIdx = 1; preIdx < pre.length; preIdx++) {
            TreeNode node = new TreeNode(pre[preIdx]);
            //we will check using post if we have already visited (constructed) this node
            while (stack.peek().val == post[postIdx]) {
                //remove the node from the stack..since the sub-tree corresponding to this node is already created
                stack.pop();
                postIdx++;
            }
            //now we are the node which is not fully constructed
            //since we are creating the tree using pre..we will first check if there is a space in left
            if (stack.peek().left == null) {
                stack.peek().left = node;
            } else {
                //else we will put the node in the right
                stack.peek().right = node;
            }
            //push the node back to the stack .. to be verified by post[]
            stack.push(node);
        }
        return root;
    }
}
