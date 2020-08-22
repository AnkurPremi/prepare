package Trees;

//Implement a function to check if a binary tree is balanced. For the purposes of
//        this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
//        node never differ by more than one.
public class CheckBalanced {

    //this is to check that every subtree is balanced
    boolean isBalancedGlobally=true;

    public static void main(String[] args) {
        CheckBalanced checkBalanced = new CheckBalanced();
        TreeNode root = checkBalanced.createSampleBalancedTree();
        System.out.println(checkBalanced.isBalanced(root));
    }

    private boolean isBalanced(TreeNode root) {
        int left = helper(root.left);
        int right = helper(root.right);
        return isBalancedGlobally && Math.abs(left - right) == 1;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = 0;
        int right = 0;
        if(!isBalancedGlobally) {
            left = helper(root.left);
            right = helper(root.right);
            if (Math.abs(left - right) > 1) isBalancedGlobally = false;
        }
        return Math.max(left, right) + 1;
    }

    public static TreeNode createSampleBalancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        return root;
    }
}
