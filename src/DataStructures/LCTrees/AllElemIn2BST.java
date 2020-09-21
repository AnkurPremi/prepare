package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllElemIn2BST {

    public static void main(String[] args) {
        int[] preorder = {8, 5, 3, 1, 4, 7, 10, 9, 12};
        TreeNode treeNode = new BSTFromPreOrder().bstFromPreorder1(preorder);
        int[] preorder1 = {3, 2, 1, 4, 12};
        TreeNode treeNode1 = new BSTFromPreOrder().bstFromPreorder1(preorder1);
        System.out.println(new AllElemIn2BST().getAllElements(treeNode, treeNode1));
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
}
