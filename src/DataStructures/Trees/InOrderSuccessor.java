package DataStructures.Trees;

//Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
//        binary search tree. You may assume that each node has a link to its parent.
public class InOrderSuccessor {
    static boolean found = false;
    static boolean stopProcess = false;
    static TreeNode requiredNode = null;

    public static void main(String[] args) {
        TreeNode node = createBST();
        TreeNode successor = getInOrderSuccessorNode(node, 12);
        System.out.println(successor.val);
        successor = getInOrderSuccessorNode(node, 27);
        System.out.println(successor);
        successor = getInOrderSuccessorNode(node, 15);
        System.out.println(successor.val);
    }

    public static TreeNode getInOrderSuccessorNode(TreeNode root, int val) {
        if (root == null) return root;
        TreeNode current = findNode(root, val);

        //Case 1: When node has right subtree
        //Find minimum in right subtree
        if (current.right != null) {
            return findMin(current.right);
        }

        //Case 2: When node has no right subtree
        //Deepest ancestor which has current in left subtree is the value
        TreeNode successor = null;
        TreeNode ancestor = root;
        while (ancestor.val != current.val) {
            //keep on moving while we find the current node
            if (current.val < ancestor.val) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }
        return successor;
    }

    //Considering node to be found exists in the tree
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return root;
        while (true) {
            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    public static TreeNode findMin(TreeNode root) {
        if (root == null) return root;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static TreeNode createBST() {
        TreeNode node = new TreeNode(15);
        node.left = new TreeNode(10);
        node.left.left = new TreeNode(8);
        node.left.left.left = new TreeNode(6);
        node.left.right = new TreeNode(12);
        node.left.right.left = new TreeNode(11);

        node.right = new TreeNode(20);
        node.right.left = new TreeNode(17);
        node.right.left.left = new TreeNode(16);
        node.right.right = new TreeNode(25);
        node.right.right.right = new TreeNode(27);

        return node;
    }
}

