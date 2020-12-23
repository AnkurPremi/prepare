package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ClosestLeafInABinaryTree {
    public static void main(String[] args) {

    }

    class Solution {

        Map<TreeNode, Integer> map = new HashMap<>();

        public int findClosestLeaf(TreeNode root, int k) {
            helper(root, k);
            int[] min = {Integer.MAX_VALUE};
            int[] ans = {root.val};
            findMin(root, 0, min, ans);
            return ans[0];
        }

        public int helper(TreeNode root, int k) {
            if (root == null) return -1;

            if (root.val == k) {
                map.put(root, 0);
                return 0;
            }

            int left = helper(root.left, k);
            if (left >= 0) {
                left = left + 1;
                map.put(root, left);
                return left;
            }

            int right = helper(root.right, k);
            if (right >= 0) {
                right = right + 1;
                map.put(root, right);
                return right;
            }

            return -1;
        }

        public void findMin(TreeNode root, int len, int[] min, int[] ans) {
            if (root == null) return;

            if (map.containsKey(root)) len = map.get(root);
            if (root.left == root.right) {
                if (len < min[0]) {
                    min[0] = len;
                    ans[0] = root.val;
                }
            }

            findMin(root.left, len + 1, min, ans);
            findMin(root.right, len + 1, min, ans);
        }

    }
}
