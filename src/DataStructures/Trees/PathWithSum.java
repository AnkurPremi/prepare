package DataStructures.Trees;
//Paths with Sum: You are given a binary tree in which each node contains an integer value (which
//might be positive or negative). Design an algorithm to count the number of paths that sum to a
//given value. The path does not need to start or end at the root or a leaf, but it must go downwards
//(traveling only from parent nodes to child nodes).
public class PathWithSum {
    private static int count;
    public static void main(String[] args) {
        TreeNode node = createRequiredTree();
        getPathsWithTheSum(node, 8);
        System.out.println(count);
    }

    public static int getPathsWithTheSum(TreeNode root, int sum){
        if(root == null) return 0;
        count += getPathsCount(root, sum);
        return count + getPathsWithTheSum(root.left, sum) + getPathsWithTheSum(root.right, sum);
    }

    public static int getPathsCount(TreeNode root, int sum){
        if(root == null){
            if(sum == 0) return 1;
            else return 0;
        };
        int left = getPathsCount(root.left, sum-root.val);
        int right = getPathsCount(root.right, sum-root.val);
        return left + right;
    }

    public static TreeNode createRequiredTree(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.left.left = new TreeNode(3);
        root.right = new TreeNode(-2);
        root.right.right = new TreeNode(11);
        return root;
    }
}
