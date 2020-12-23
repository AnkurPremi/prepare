package DataStructures.NewWork.DP;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateUniqueBST {
    public static void main(String[] args) {
        System.out.println(new GenerateUniqueBST().generateTrees(7));
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList();
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        return helper(1, n, dp);
    }

    private List<TreeNode> helper(int start, int end, List<TreeNode>[][] dp) {
        List<TreeNode> ans = new ArrayList();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if(dp[start][end] != null) return dp[start][end];

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = helper(start, i - 1, dp);
            List<TreeNode> rightList = helper(i + 1, end, dp);

            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        dp[start][end] = ans;
        return dp[start][end];
    }
}
