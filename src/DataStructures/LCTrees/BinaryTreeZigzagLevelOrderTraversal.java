package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(6);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(7);
        node.right = new TreeNode(10);
        node.right.right = new TreeNode(14);
        node.right.right.left = new TreeNode(13);
        CommonUtil.levelOrderPrint(node);
        System.out.println("---------------------------");
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(node));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        Stack<Integer> stack = new Stack<>();
        int level = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                size--;
                TreeNode node = dq.poll();
                if (level % 2 == 0) {
                    stack.push(node.val);
                } else {
                    list.add(node.val);
                }
                if(node.left != null) dq.offer(node.left);
                if(node.right != null) dq.offer(node.right);
            }
            level++;
            while(!stack.isEmpty()){
                list.add(stack.pop());
            }
            result.add(list);
        }
        return result;
    }

}
