package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class SmallestStringFromLeafToRoot {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(6);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(7);
        node.right = new TreeNode(10);
        node.right.right = new TreeNode(14);
        node.right.right.left = new TreeNode(13);
        Map<Integer, String> map  = new HashMap<>();
        for(int i='a' ; i<='z' ;i++){
            map.put( i - 'a', String.valueOf((char)i));
        }
        System.out.println(new SmallestStringFromLeafToRoot().smallestFromLeaf(node));
    }

    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        Map<Integer, String> map  = new HashMap<>();
        for(int i='a' ; i<='z' ;i++){
            map.put( i - 'a', String.valueOf((char)i));
        }
        return smallestFromLeaf(root, map);
    }

    public String smallestFromLeaf(TreeNode root, Map<Integer, String> map) {
        if(root == null) return "";
        if(root.left == null && root.right == null){
            return map.get(root.val);
        }
        String left = smallestFromLeaf(root.left, map);
        String right = smallestFromLeaf(root.right, map);

        if(left.compareTo(right) < 0){
            return left + map.get(root.val);
        }else{
            return right + map.get(root.val);
        }
    }
}
