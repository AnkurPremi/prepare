package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBt {
    public static void main(String[] args) {
        System.out.println(new AllPossibleFBt().allPossibleFBT(7));
    }

    public List<TreeNode> allPossibleFBT(int N) {
        return helper(N);
    }

    private List<TreeNode> helper(int n) {
        List<TreeNode> result = new ArrayList();
        if (n <= 0) {
            result.add(null);
            return result;
        }
        for (int i = 1; i <= n; i += 2) {
            List<TreeNode> leftList = helper(i - 1);
            List<TreeNode> rightList = helper(n - i - 1);

            TreeNode root = new TreeNode(0);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
