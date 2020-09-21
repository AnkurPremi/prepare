package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.*;

public class VerticalOrderTraversalBinaryTree {
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
        System.out.println(new VerticalOrderTraversalBinaryTree().verticalTraversal(node));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, Map<Integer, TreeSet<Integer>>> map = new TreeMap<>();
        verticalTraversal(root, 0, 0, map);
        for (Map.Entry<Integer, Map<Integer, TreeSet<Integer>>> entry : map.entrySet()) {
            for (Map.Entry<Integer, TreeSet<Integer>> entry1 : entry.getValue().entrySet()) {
                result.add(new ArrayList<>(entry1.getValue()));
            }
        }
        return result;
    }

    public void verticalTraversal(TreeNode root, int x, int y, Map<Integer, Map<Integer, TreeSet<Integer>>> map) {
        if (root == null) return;
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new TreeSet<>());
        }
        map.get(x).get(y).add(root.val);
//        map.computeIfAbsent(vLevel, k-> new TreeSet()).add(root.val);
        verticalTraversal(root.left, x - 1, y + 1, map);
        verticalTraversal(root.right, x + 1, y + 1, map);
    }
}
