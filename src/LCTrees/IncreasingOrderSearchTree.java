package LCTrees;

import Trees.SumLeftLeaves;
import Trees.TreeNode;

public class IncreasingOrderSearchTree {
    static TreeNode finalHead = null;

    public static void main(String[] args) {
        TreeNode node = SumLeftLeaves.createLargeBST();
        new IncreasingOrderSearchTree().increasingBST(node);
        System.out.println("adsad");
    }


    static TreeNode prev = null, head = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        increasingBST(root.left);
        if (prev != null) {
            root.left = null; // we no  longer needs the left  side of the node, so set it to null
            prev.right = root;
        }
        if (head == null) head = root; // record the most left node as it will be our root
        prev = root; //keep track of the prev node
        increasingBST(root.right);
        return head;
    }
}
