package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

public class BTNextPointer2 {
    public static void main(String[] args) {
        Integer[] arr = {2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7};
        Node node = new BTNextPointer2().convertTree(arr, 0);
        new BTNextPointer2().connect(node);
    }

    public Node connect(Node root) {
        if(root == null) return root;

        if(root.left != null){
            if(root.right != null)
                root.left.next = root.right;
            else{
                Node node = root.next;
                while(node != null){
                    if(node.left != null){
                        root.left.next = node.left;
                        break;
                    }
                    else if(node.right != null){
                        root.left.next = node.right;
                        break;
                    }
                    else{
                        node = node.next;
                    }
                }
            }
        }

        if(root.right != null){
            if(root.right.val == 0)
                System.out.println("check");
            Node node = root.next;
            while(node != null){
                if(node.left != null){
                    root.right.next = node.left;
                    break;
                }
                else if(node.right != null){
                    root.right.next = node.right;
                    break;
                }
                else{
                    node = node.next;
                }
            }
        }

        connect(root.left);
        connect(root.right);

        return root;
    }

    class Node {
        int val;

        Node(int val) {
            this.val = val;
        }

        Node next;
        Node left;
        Node right;

    }
    //[2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7]
    public Node convertTree(Integer[] arr, int start){
            if(start >= arr.length) return null;
            if(arr[start] == null) return null;
            Node node = new Node(arr[start]);
            node.left = convertTree(arr, 2*start + 1);
            node.right = convertTree(arr, 2*start + 2);
            return node;
    }
}
