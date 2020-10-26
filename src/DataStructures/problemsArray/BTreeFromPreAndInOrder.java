package DataStructures.problemsArray;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class BTreeFromPreAndInOrder {
    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] ino = {9,3,15,20,7};
        new BTreeFromPreAndInOrder().buildTree1(pre, ino);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIdx = new int[]{0};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode head = helper(preorder, map, preIdx, 0, inorder.length-1);
        return head;
    }

    private TreeNode helper(int[] preorder, Map<Integer, Integer> map,int[] preIdx, int start, int end){
        if(start > end) return null;

        //create the node from the latest idx in preorder
        TreeNode node = new TreeNode(preorder[preIdx[0]++]);
        if(start == end) return node;
        //search for the above created node in inorder..to divide the inorder into two halves
        int idx = -1;
        if(map.containsKey(node.val)){
            idx = map.get(node.val);
        }
//        int idx = searchInInorder(inorder, node.val, start, end);
        if(idx == -1) return null;
        //create the left tree
        node.left = helper(preorder, map, preIdx, start, idx-1);
        //create the right tree
        node.right = helper(preorder, map, preIdx, idx+1, end);
        return node;
    }


    int idx = 0;
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, n-1, map);
    }

    public TreeNode helper(int[] preorder, int start, int end, Map<Integer, Integer> map) {
        if(start > end) return null;

        TreeNode node = new TreeNode(preorder[idx++]);
        if(start == end) return node;

        //find the index of the element in the hashmap
        //which will be used to divide the tree into left and right
        //using inorder traversal
        int inIdx = map.getOrDefault(node.val, -1);
        if(inIdx == -1) return null;

        node.left = helper(preorder, start, inIdx-1, map);
        node.right = helper(preorder, inIdx+1, end, map);

        return node;
    }

    private int searchInInorder(int[] inorder,int target, int start, int end){
        if(start > end) return -1;
        for(int i=start ;i<=end ;i++){
            if(inorder[i] == target) return i;
        }
        return -1;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

