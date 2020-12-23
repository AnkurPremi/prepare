package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

public class IsValidSequenceInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new IsValidSequenceInBinaryTree().convertTreeFromArrLC(new Integer[]{0,1,0,0,1,0,null,null,1,0,0}, 0);
        System.out.println(new IsValidSequenceInBinaryTree().isValidSequence(root, new int[]{0,0,1}));
    }

    int size = 0;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        int[] map = new int[10];
        size = arr.length;
        for (int i : arr) {
            map[i]++;
        }

        boolean[] ans = {false};
        helper(root, map, new int[1], ans);
        return ans[0];
    }

    public void helper(TreeNode root, int[] map, int[] count, boolean[] ans) {
        if (root == null) return;

        if (map[root.val] <= 0 && count[0] < size)
            return;

        map[root.val]--;
        count[0]++;

        if (count[0] == size) {
            boolean isValid = valid(map);
            if (isValid) {
                ans[0] = true;
            } else {
                map[root.val]++;
                count[0]--;
            }
            return;
        }

        helper(root.left, map, count, ans);
        helper(root.right, map, count, ans);

    }

    private boolean valid(int[] map) {
        for (int i : map) {
            if (i != 0)
                return false;
        }
        return true;
    }

    public TreeNode convertTreeFromArrLC(Integer[] arr, int start){
        if(start >= arr.length) return null;
        if(arr[start] == null) return null;
        TreeNode node = new TreeNode(arr[start]);
        node.left = convertTreeFromArrLC(arr, 2*start + 1);
        node.right = convertTreeFromArrLC(arr, 2*start + 2);
        return node;
    }
}
