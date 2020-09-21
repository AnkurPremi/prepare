package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NodesKDistanceFromTarget {

    public static void main(String[] args) {
        TreeNode target = null;
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(6);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(7);
        node.right = new TreeNode(10);
        target = node.right;
        node.right.right = new TreeNode(14);
        node.right.left = new TreeNode(13);
        node.right.left.left = new TreeNode(16);
        node.right.left.right = new TreeNode(17);

        new NodesKDistanceFromTarget().distanceK(node, target, 2);
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, K, map.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.putIfAbsent(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.putIfAbsent(root, left+1);
            return left + 1;
        }

        int right = find(root.right, target);
        if (right >= 0) {
            map.putIfAbsent(root, right+1);
            return right + 1;
        }

        return -1;
    }
//we are storing the values in the map
    private void dfs(TreeNode root, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, K, length + 1, res);
        dfs(root.right, K, length + 1, res);
    }

}
