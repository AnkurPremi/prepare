package Trees;

public class SumLeftLeaves {
    public static void main(String[] args) {
        TreeNode treeNode = createLargeBST();
        System.out.println(getSumOfLeftLeaves(treeNode));
    }

    static int getSumOfLeftLeaves(TreeNode root){
        int sum = 0;
        if(root != null){
            if(root.left != null){
                sum += root.left.val;
                sum += getSumOfLeftLeaves(root.left);
            }
            if(root.right != null){
                sum += getSumOfLeftLeaves(root.right);
            }
        }
        return sum;
    }
    public static TreeNode createLargeBST() {
        TreeNode node = new TreeNode(25);
        node.left = new TreeNode(20);
        node.left.left = new TreeNode(18);
        node.left.left.left = new TreeNode(16);
        node.left.right = new TreeNode(22);
        node.left.right.left = new TreeNode(21);

        node.right = new TreeNode(45);
        node.right.left = new TreeNode(27);
        node.right.left.left = new TreeNode(26);
        node.right.right = new TreeNode(55);
        return node;
    }
}


