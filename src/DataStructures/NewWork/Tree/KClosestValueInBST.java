package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KClosestValueInBST {
    public static void main(String[] args) {
        TreeNode node=  new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(5);
        System.out.println(new KClosestValueInBST().closestKValues(node, 3.71426, 2));
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList();
        getData(root, list);
        List<Integer> ans = new ArrayList();

        int l = 0, r = list.size() - 1;
        if (target < list.get(0)) {
            for (int i = 0; i < k && i < list.size(); i++) {
                ans.add(list.get(i));
            }
            return ans;
        }

        if (target > list.get(r)) {
            for (int i = r; i >= 0 && k > 0; i--, k--) {
                ans.add(list.get(i));
            }
            return ans;
        }

        while (r - l + 1 > k) {
            if (Math.abs(target - list.get(l)) > Math.abs(target - list.get(r))) {
                l++;
            } else {
                r--;
            }
        }

        for (int i = l; i <= r; i++) {
            ans.add(list.get(i));
        }

        return ans;

    }

    private void getData(TreeNode root, List<Integer> list) {
        if (root == null) return;
        getData(root.left, list);
        list.add(root.val);
        getData(root.right, list);
    }
}
