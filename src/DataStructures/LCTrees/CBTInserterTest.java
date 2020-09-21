//package DataStructures.LCTrees;
//
//import DataStructures.Trees.TreeNode;
//
//import java.util.ArrayList;
//import java.util.DataStructures.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class CBTInserterTest {
//}
//
//class CBTInserter {
//
//    Queue<TreeNode> queue = null;
//    TreeNode head = null;
//    TreeNode currentNode = null;
//
//    public CBTInserter(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        queue = new DataStructures.LinkedList<TreeNode>();
//        head = root;
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            if(node.left == null && node.right == null){
//                currentNode = node;
//                break;
//            }
//            if(node.left != null){
//                queue.offer(node.left);
//            }
//            if(node.right != null){
//                queue.offer(node.right);
//            }
//        }
//
//    }
//
//    public int insert(int v) {
////        if(currentNode.left == null){
////            currenNode.left = new TreeNode(v);
////            queue.offer(currentNode.left);
////        }else if(currentNode.right == null){
////            currenNode.right = new TreeNode(v);
////            queue.offer(currentNode.right);
////        } else{
////            currentNode = queue.poll();
////            currenNode.left = new TreeNode(v);
////            queue.offer(currentNode.left);
////        }
////        return currentNode;
//    }
//
//    public TreeNode get_root() {
//        return head;
//    }
//}
//
