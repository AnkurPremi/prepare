package Trees;

import java.util.*;

public class NAryTree {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(3);
        List<Node> list2 = Arrays.asList(node1, new Node(2), new Node(4));
        List<Node> list1 = Arrays.asList(new Node(5), new Node(6));
        node1.children = list1;
        node.children = list2;
        List<List<Integer>> finalList = levelOrder(node);
        System.out.println(finalList);
    }

    static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if (root == null) return finalList;
        else {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(null);
            List<Integer> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node == null) {
                    List<Integer> newList = new LinkedList<>(list);
                    finalList.add(newList);
                    list.clear();
                    if (queue.isEmpty()) break;
                } else {
                    list.add(node.val);
                    if(node.children == null) continue;
                    for (int i = 0; i < node.children.size(); i++) {
                        queue.offer(node.children.get(i));
                    }
                    queue.offer(null);
                }
            }
        }
        return finalList;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
