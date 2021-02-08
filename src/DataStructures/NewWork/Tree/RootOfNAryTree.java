package DataStructures.NewWork.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RootOfNAryTree {
    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList<>();
        Node root = new Node(1);
        nodeList.add(root);
        nodeList.add(null);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        nodeList.addAll(Arrays.asList(node2, node3, node4, node5));
        nodeList.add(null);
        nodeList.add(null);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        nodeList.addAll(Arrays.asList(node6, node7));
        nodeList.add(null);
        Node node8 = new Node(8);
        nodeList.addAll(Arrays.asList(node8));
        nodeList.add(null);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        nodeList.addAll(Arrays.asList(node9, node10));
        nodeList.add(null);
        nodeList.add(null);
        Node node11 = new Node(11);
        nodeList.addAll(Arrays.asList(node11));
        nodeList.add(null);
        Node node12 = new Node(12);
        nodeList.addAll(Arrays.asList(node12));
        nodeList.add(null);
        Node node13 = new Node(13);
        nodeList.addAll(Arrays.asList(node13));
        nodeList.add(null);
        nodeList.add(null);
        Node node14 = new Node(14);
        nodeList.addAll(Arrays.asList(node14));
        root = new RootOfNAryTree().findRoot(nodeList);
    }
    int idx = 0;
    public Node findRoot(List<Node> tree) {
        Node root = tree.get(0);
        idx += 2;
        List<Node> list = new ArrayList();
        while(idx < tree.size() && tree.get(idx) != null){
            list.add(tree.get(idx++));
        }
        root.children = list;
        idx++;
        helper(tree, list);
        return root;
    }

    public void helper(List<Node> tree, List<Node> children){
        if(idx >= tree.size() || children == null) {
            idx++;
            return;
        }

        for(Node node : children){
            List<Node> childNodes = new ArrayList();
            boolean added = false;
            while(idx < tree.size() && tree.get(idx) != null){
                childNodes.add(tree.get(idx));
                idx++;
                added = true;
            }
            if(!added) {
                idx++;
                childNodes = null;
            }
            if(tree.get(idx) == null) idx++;
            node.children = childNodes;
        }

        for(Node node : children){
            helper(tree, node.children);
        }

    }
}


