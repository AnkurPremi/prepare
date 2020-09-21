package DataStructures.LCTrees;

import DataStructures.Trees.TreeNode;

public class RecoverATreeFromPreOrder {
    public static void main(String[] args) {
        String s = "1-2--3--4-5--6--7";
        TreeNode root = new RecoverATreeFromPreOrder().recoverFromPreorder(s);
        System.out.println("dasda");
    }

    public TreeNode recoverFromPreorder(String S) {
        return dfs(S, new int[1], 0);
    }

    public TreeNode dfs(String s, int[] idx, int prevCount){
        if(idx[0] == s.length()) return null;

        int count = countDash(s, idx);
        if(count < prevCount && count != 0){
            return null;
        }
        TreeNode root = new TreeNode(getNum(s, idx));
        root.left = dfs(s, idx, count+1);
        root.right = dfs(s, idx, count+1);

        return root;
    }

    public int countDash(String s, int[] idx){
        int count = 0;
        int i = idx[0];
        int j=i;
        for(; j<s.length(); j++){
            if(s.charAt(j) == '-') count++;
            else break;
        }
        idx[0] += (j-i);
        return count;
    }

    public int getNum(String s, int[] idx){
        int num = 0;
        int i = idx[0];
        int j=i;
        for(; j<s.length(); j++){
            if(s.charAt(j) != '-') {
                num = num*10 + (s.charAt(j) - '0');
            }
            else break;
        }
        idx[0] += (j-i);
        return num;
    }
}
