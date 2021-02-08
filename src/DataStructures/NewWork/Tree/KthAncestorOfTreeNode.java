package DataStructures.NewWork.Tree;

import java.util.Arrays;

public class KthAncestorOfTreeNode {
    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        TreeAncestor treeAncestor = new TreeAncestor(7, parent);
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }

}

class TreeAncestor {

    int[] arr;

    public TreeAncestor(int n, int[] parent) {
        arr = new int[n];
        Arrays.fill(arr, -2);
        init(parent);
    }

    private void init(int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            arr[i] = parent[i];
        }
    }

    public int getKthAncestor(int node, int k) {
        if (arr[node] == -2) return -1;
        int p = arr[node];
        k--;
        while (k > 0) {
            if (arr[p] == -2) return -1;
            p = arr[p];
            k--;
        }
        return p;
    }
}