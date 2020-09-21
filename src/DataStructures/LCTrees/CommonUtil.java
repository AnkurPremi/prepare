package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CommonUtil {

    public static void levelOrderPrint(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                size--;
                TreeNode node = queue.poll();
                System.out.print(node.val +",");
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            System.out.println("");
            System.out.println("---------------");
        }
    }
}
