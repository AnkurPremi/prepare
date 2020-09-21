package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(1);
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(node));
    }

    public int deepestLeavesSum(TreeNode root) {
             if(root == null) return 0;
             Queue<TreeNode> q = new LinkedList<TreeNode>();
             q.offer(root);
             int sum = 0;
             while(!q.isEmpty()){
                 int size = q.size();
                 sum = 0;
                 while(size>0){
                     TreeNode node = q.poll();
                     sum += node.val;
                     if(root.left != null){
                         q.offer(root.left);
                     }
                     if(root.right != null){
                         q.offer(root.right);
                     }
                     size--;
                 }
             }
             return sum;
         }
}
