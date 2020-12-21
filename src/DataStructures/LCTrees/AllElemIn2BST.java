package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.*;

public class AllElemIn2BST {

    public static void main(String[] args) {
        int[] preorder = {8, 5, 3, 1, 4, 7, 10, 9, 12};
        TreeNode treeNode = new BSTFromPreOrder().bstFromPreorder1(preorder);
        int[] preorder1 = {3, 2, 1, 4, 12};
        TreeNode treeNode1 = new BSTFromPreOrder().bstFromPreorder1(preorder1);
        System.out.println(new AllElemIn2BST().ans(treeNode, treeNode1));
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        if (root1 == null && root2 == null) return result;
        Queue<Integer> queue = new LinkedList<>();

        if (root1 != null && root2 == null) {
            inOrder(root1, queue, result);
        } else if (root1 == null && root2 != null) {
            inOrder(root2, queue, result);
        } else {
            inOrder(root1, queue);
            inOrder(root2, queue, result);
            while (!queue.isEmpty()) {
                result.add(queue.poll());
            }
        }
        return result;

    }

    public void inOrder(TreeNode root, Queue<Integer> queue) {
        if (root == null) return;
        inOrder(root.left, queue);
        queue.offer(root.val);
        inOrder(root.right, queue);
    }

    public void inOrder(TreeNode root, Queue<Integer> queue, List<Integer> result) {
        if (root == null) return;
        inOrder(root.left, queue, result);
        if (queue == null || queue.isEmpty()) {
            result.add(root.val);
        } else if (queue.peek() <= root.val) {
            while (!queue.isEmpty() && queue.peek() <= root.val) {
                result.add(queue.poll());
            }
        }
        result.add(root.val);
        inOrder(root.right, queue, result);
    }

    public List<Integer> ans(TreeNode root1, TreeNode root2){
        List<Integer> result = new ArrayList();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode r1 = root1, r2 = root2;
        while(r1 != null || r2 != null || !stack1.isEmpty() || !stack2.isEmpty()){
            while(r1.left != null){
                stack1.push(r1);
                r1 = r1.left;
            }

            while(r2.left != null){
                stack2.push(r2);
                r2 = r2.left;
            }

            if(stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().val <= stack2.peek().val)){
                r1 = stack1.pop();
                result.add(r1.val);
                r1 = r1.right;
            } else{
                r2 = stack2.pop();
                result.add(r2.val);
                r2 = r2.right;
            }
        }


        return result;
    }
}
