package Trees;

import java.util.ArrayList;
import java.util.List;

//create bst in O(n)
public class SortedListToBST {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) list.add(i);
        TreeNode root = new SortedListToBST().createTree(0, list.size()-1, list);
        System.out.println(root);
    }

    public TreeNode createTree(int start, int end, List<Integer> list) {
        if (start > end) return null;
        int mid = (start + end) >> 1;

        TreeNode left = createTree(start, mid - 1, list);
        TreeNode root = new TreeNode(list.get(mid));
        TreeNode right = createTree(mid + 1, end, list);

        root.left = left;
        root.right = right;

        return root;
    }
}

