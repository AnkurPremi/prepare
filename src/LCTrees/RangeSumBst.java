package LCTrees;

public class RangeSumBst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(new RangeSumBst().rangeSumBST(root, 7, 15));
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        int[] sum = new int[1];
        helper(root, L, R, sum);
        return sum[0];
    }

    public void helper(TreeNode root, int l, int r, int[] sum){
        if(root == null) return;

        if(root.val >= l){
            helper(root.left, l, root.val, sum);
        }
        if(l <= root.val && root.val <= r){
            sum[0] += root.val;
        }

        if(root.val <= r){
            helper(root.right, root.val, r, sum);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
