package DataStructures.Trees;

//First Common Ancestor: Design an algorithm and write code to find the first common ancestor
//        of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
//        necessarily a binary search tree.
public class LowestCommonAncestor {
    static boolean found;
    static TreeNode value = null;

    public static void main(String[] args) {
        TreeNode node = InOrderSuccessor.createBST();
        getLCA(node, 8, 12);
        System.out.println(value.val);
        value = null; found=false;
        getLCA(node, 11, 16);
        System.out.println(value.val);
        value = null; found=false;
        getLCA(node, 6, 28);
        System.out.println(value.val);
    }

    public static TreeNode getLCA(TreeNode root, int data1, int data2) {
        if (root == null) return null;
        if (!found) {
            if (root.val == data1 || root.val == data2)
                return root;
            TreeNode left = getLCA(root.left, data1, data2);
            TreeNode right = getLCA(root.right, data1, data2);

            if (left != null && right != null) {
                value = root;
                found = true;
                return root;
            } else if (left != null)
                return left;
            else if (right != null)
                return right;
        }
        return null;
    }
}
