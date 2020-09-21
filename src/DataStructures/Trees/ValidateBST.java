package DataStructures.Trees;

//Implement a function to check if a binary tree is a binary search tree.
public class ValidateBST {
    public static void main(String[] args) {
        CheckBalanced checkBalanced = new CheckBalanced();
        Object[] arr = new Object[2];
        arr[0] = Integer.MIN_VALUE;
        arr[1] = true;
        TreeNode node = checkBalanced.createSampleBalancedTree();
        System.out.println(validateBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(validateBST(node, arr));
        node = createBST();
        arr[0] = Integer.MIN_VALUE;
        arr[1] = true;
        System.out.println(validateBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(validateBST(node, arr));
    }


    public static boolean validateBST(TreeNode node, int minVal, int maxVal) {
        if (node == null) return true;
        return (node.val > minVal && node.val < maxVal) && validateBST(node.left, minVal, node.val) && validateBST(node.right, node.val, maxVal);
    }

    public static boolean validateBST(TreeNode node, Object[] arr) {
        if (node == null) return true;

        boolean left = (Boolean)arr[1] ? validateBST(node.left, arr): false;;
        if (node.val > (Integer)arr[0]) {
            arr[0] = node.val;
        } else {
            arr[1] = false;
            return false;
        }
        boolean right = (Boolean)arr[1] ? validateBST(node.right, arr): false;

        return left && right;
    }

    public static TreeNode createBST() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(-1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(11);
        return root;
    }
}
