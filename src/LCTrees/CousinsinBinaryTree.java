package LCTrees;

import Trees.SumLeftLeaves;
import Trees.TreeNode;

public class CousinsinBinaryTree {

    public static void main(String[] args) {
        TreeNode node = SumLeftLeaves.createLargeBST();
        System.out.println(new CousinsinBinaryTree().isCousins(node,  21,26));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Temp val1 = helper(root, root, x, 1);
        Temp val2 = helper(root, root, y, 1);
        return val1.node != val2.node && val1.level == val2.level;
    }

    public Temp helper(TreeNode root, TreeNode parent, int x, int level){
        if(root == null) return null;
        if(root.val == x){
            return new Temp(level, parent);
        }
        Temp val = helper(root.left,root,x,level+1);
        if(val == null){
            val = helper(root.right,root,x,level+1);
        }
        return val;
    }

    class Temp{
        TreeNode node;
        int level;
        public Temp(int l, TreeNode n){
            this.node = n;
            this.level = l;
        }
    }
}
