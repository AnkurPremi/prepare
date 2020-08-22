package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, design an algorithm which creates a linked list of all the nodes
//        at each depth (e.g., if you have a tree with depth D, you'll have D linked lists)
public class ListOfDepths {
    public static void main(String[] args) {
        ListOfDepths listOfDepths = new ListOfDepths();
        SpecialTreeNode root = listOfDepths.createSampleBalancedTree();
        List<SpecialTreeNode> list = new ArrayList<>();
        listOfDepths.createLLFromTree(root, list);
        System.out.println("check specialTree");
    }

    public void createLLFromTree(SpecialTreeNode root, List<SpecialTreeNode> list) {

        Queue<SpecialTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        SpecialTreeNode prevNode = null;//will move and add the next pointer using DFS
        SpecialTreeNode head = null;//for storing head to the list
        while (!queue.isEmpty()) {
            SpecialTreeNode node = queue.poll();
            if (node == null) {
                list.add(head);
                if (queue.size() != 0) {
                    queue.offer(null);
                    prevNode = null;//new list will be created now
                    continue;
                } else {
                    break;
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            node.left = null;
            node.right = null;

            if (prevNode == null) {
                prevNode = node;
                head = prevNode;//new LL head node
            } else {
                prevNode.next = node;
                prevNode = node;
            }
        }
    }

    public SpecialTreeNode createSampleBalancedTree() {
        SpecialTreeNode root = new SpecialTreeNode(1);
        root.left = new SpecialTreeNode(2);
        root.left.left = new SpecialTreeNode(3);
        root.left.right = new SpecialTreeNode(4);
        root.right = new SpecialTreeNode(5);
        root.right.left = new SpecialTreeNode(6);
        root.right.right = new SpecialTreeNode(7);
        root.right.right.right = new SpecialTreeNode(11);
        return root;
    }
}

class SpecialTreeNode {
    SpecialTreeNode next;
    SpecialTreeNode left;
    SpecialTreeNode right;
    int value;

    SpecialTreeNode(int value) {
        this.value = value;
    }
}