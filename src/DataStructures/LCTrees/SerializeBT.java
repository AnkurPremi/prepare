package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.Arrays;
import java.util.List;

public class SerializeBT {
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
        String serialized = new SerializeBT().serialize(node);
        TreeNode root = new SerializeBT().deserialize(serialized);
        System.out.println("dasdasd");
    }

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serializeHelper(root, builder);
        return builder.toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#").append(",");
            return;
        }
        builder.append(root.val).append(",");
        serializeHelper(root.left, builder);
        serializeHelper(root.right, builder);

    }

    public TreeNode deserialize(String data) {
        return deserializeHelper(Arrays.asList(data.split(",")), new int[1]);
    }

    public TreeNode deserializeHelper(List<String> data, int[] idx) {
        if (data.get(idx[0]).equals("#")) {
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.get(idx[0]++)));
        root.left = deserializeHelper(data, idx);
        root.right = deserializeHelper(data, idx);
        return root;
    }
}
