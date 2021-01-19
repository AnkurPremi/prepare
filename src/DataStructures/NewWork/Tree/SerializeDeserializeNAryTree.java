package DataStructures.NewWork.Tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeNAryTree {
    public static void main(String[] args) {
        List<Node> childList = new ArrayList<>();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        childList.add(node2);
        childList.add(node4);
        childList.add(node3);
        List<Node> childList2 = new ArrayList<>();
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        childList2.add(node5);
        childList2.add(node6);
        node3.children = childList2;
        node1.children = childList;
        String s = new Codec().serialize(node1);
        System.out.println(s);
        new Codec().deserialize(s);
    }
}

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder builder = new StringBuilder();
        serializeHelper(root, builder);
        return builder.toString();
    }

    private void serializeHelper(Node root, StringBuilder builder) {
        if (root == null) {
            builder.append("#").append(",");
            return;
        }
        builder.append(root.val).append(",");
        if (root.children == null) {
            return;
        }
        builder.append("(").append(",");
        for (Node node : root.children) {
            serializeHelper(node, builder);
        }
        builder.append(")").append(",");
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] strs = data.split(",");
        return deserializeHelper(strs);
    }

    int idx = 0;

    public Node deserializeHelper(String[] data) {
        if (idx == data.length || data[idx].equals("#")) {
            idx++;
            return null;
        }

        Node root = new Node(Integer.parseInt(data[idx++]));

        if (data[idx].equals("(")) {
            List<Node> childList = new ArrayList();
            idx++;
            while (!data[idx].equals(")")) {
                childList.add(deserializeHelper(data));
            }
            idx++;
            root.children = childList;
        }

        return root;
    }

}


