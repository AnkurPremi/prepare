package DataStructures.problemsArray;

import DataStructures.Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class BTreeFromPostAndInOrder {
    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] po = {9,15,7,20,3};
        new BTreeFromPostAndInOrder().buildTree(in, po);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postIdx = new int[]{postorder.length - 1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, map, postIdx, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postOrder, Map<Integer, Integer> map, int[] postIdx, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(postOrder[postIdx[0]--]);
        if (start == end) return node;
        int idx = -1;
        if (map.containsKey(node.val)) {
            idx = map.get(node.val);
        }
        if (idx == -1) return null;
        node.right = helper(postOrder, map, postIdx, idx + 1, end);
        node.left = helper(postOrder, map, postIdx, start, idx - 1);
        return node;
    }
}
