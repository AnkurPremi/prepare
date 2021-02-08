package DataStructures.NewWork.graph;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = new ArrayList<>(Arrays.asList(node3, node4));
        node4.neighbors = new ArrayList<>(Arrays.asList(node1, node2));
        node2.neighbors = new ArrayList<>(Arrays.asList(node3, node4));
        node3.neighbors = new ArrayList<>(Arrays.asList(node1, node2));
        node1 = new CloneGraph().cloneGraph(node1);
    }

    public Node cloneGraph(Node node) {
        if (node == null) return node;

        Map<Node, Node> map = new HashMap<>();
        Map<Node, Boolean> seen = new HashMap<>();
        accumulate(node, map, seen);
        Node newNode = map.get(node);
        seen = new HashMap<>();
        createNew(node, map, newNode, seen);
        return newNode;
    }

    private void accumulate(Node node, Map<Node, Node> map, Map<Node, Boolean> seen) {
        if (node == null) return;
        if (seen.containsKey(node)) return;
        map.put(node, new Node(node.val));
        if (node.neighbors != null || !node.neighbors.isEmpty()) {
            for (Node neigh : node.neighbors) {
                accumulate(neigh, map, seen);
            }
        }
        seen.put(node, true);
    }

    private void createNew(Node node, Map<Node, Node> map, Node newNode, Map<Node, Boolean> seen) {
        if (node == null || newNode == null) return;
        if (seen.containsKey(node)) return;
        List<Node> neighbors = null;
        if (node.neighbors != null || !node.neighbors.isEmpty()) {
            neighbors = new ArrayList();
            for (Node neigh : node.neighbors) {
                neighbors.add(map.get(neigh));
                createNew(neigh, map, map.get(neigh), seen);
            }
        }
        newNode.neighbors = neighbors;
        seen.put(node, true);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}