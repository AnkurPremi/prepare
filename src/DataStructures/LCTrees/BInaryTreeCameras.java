package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BInaryTreeCameras {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        System.out.println(new BInaryTreeCameras().minCameraCover(root));
    }

    int min = Integer.MAX_VALUE;

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        return minCameraCover(root, new HashMap<>());
    }

    public int minCameraCover(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int left = 0, right = 0;
        if (root.left != null) {
            left = minCameraCover(root.left.left, map) + minCameraCover(root.left.right, map);
        }
        if (root.right != null) {
            right = minCameraCover(root.right.left, map) + minCameraCover(root.right.right, map);
        }
        int val = 1 + left + right;
        val = Math.min(val, minCameraCover(root.left, map) + minCameraCover(root.right, map));
        map.put(root, val);
        min = Math.min(min, val);
        Long l = Long.MAX_VALUE;

        return val;
    }
}
