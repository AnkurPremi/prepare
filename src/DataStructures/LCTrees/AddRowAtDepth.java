package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

public class AddRowAtDepth {
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
        CommonUtil.levelOrderPrint(new AddRowAtDepth().addOneRow(node, 1, 5));
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return root;
        }
        root.left = addRow(root.left, v, d, 2, true);
        root.right = addRow(root.right, v, d, 2, false);
        return root;
    }

    public TreeNode addRow(TreeNode root, int v, int d, int i, boolean left) {
        if (root == null) {
            if (d == i) return new TreeNode(v);
            return null;
        }
        if (d == i) {
            TreeNode node = new TreeNode(v);
            if (left) {
                node.left = root;
            } else {
                node.right = root;
            }
            return node;
        }
        root.left = addRow(root.left, v, d, i + 1, true);
        root.right = addRow(root.right, v, d, i + 1, false);
        return root;
    }

}
