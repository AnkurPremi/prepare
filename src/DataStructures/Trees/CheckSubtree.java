package DataStructures.Trees;

//Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
//algorithm to determine if T2 is a subtree of Tl.
//A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
//That is, if you cut off the tree at node n, the two trees would be identical.
public class CheckSubtree {

    public static void main(String[] args) {
        TreeNode t1 = createLargeBST();
        TreeNode t2 = InOrderSuccessor.createBST();
        System.out.println(checkSubtree(t1, t2));
    }

    public static boolean checkSubtree(TreeNode t1, TreeNode t2) {
        if (t1 == null) return false;
        //case when there are duplicate values
        //we have multiple times t2 root val in t1
        if (t1.val == t2.val && compareTree(t1, t2)) {
            return true;
        }
        return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);
    }

    public static boolean compareTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return compareTree(t1.left, t2.left) && compareTree(t1.right, t2.right);

    }

    public static TreeNode createLargeBST() {
        TreeNode node = new TreeNode(25);
        node.left = new TreeNode(20);
        node.left.left = new TreeNode(18);
        node.left.left.left = new TreeNode(16);
        node.left.right = new TreeNode(22);
        node.left.right.left = new TreeNode(21);

        node.right = new TreeNode(15);
        node.right.left = new TreeNode(27);
        node.right.left.left = new TreeNode(26);
        node.right.right = new TreeNode(35);
        node.right.right.right = InOrderSuccessor.createBST();
        return node;
    }
}
