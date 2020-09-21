package DataStructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given a BST, return all the possible seq which can be used to create the tree
//Complex
public class BSTSeq {
    public static void main(String[] args) {
        TreeNode node = InOrderSuccessor.createBST();
        List<LinkedList<Integer>> list = getAllSeq(node);
        System.out.println("asdas");
    }

    public static List<LinkedList<Integer>> getAllSeq(TreeNode root) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        if (root == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(root.val);
        List<LinkedList<Integer>> leftSeq = getAllSeq(root.left);
        List<LinkedList<Integer>> rightSeq = getAllSeq(root.right);

        for (LinkedList<Integer> first : leftSeq) {
            for (LinkedList<Integer> second : rightSeq) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveList(first, second, weaved, list);
                result.addAll(weaved);
            }
        }
        return result;
    }

    public static void weaveList(LinkedList<Integer> first, LinkedList<Integer> second, List<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if(first.size() ==0 || second.size() == 0){
            LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headfirst = first.removeFirst();
        prefix.addLast(headfirst);
        weaveList(first, second, results, prefix);
        first.addFirst(headfirst);


        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveList(first, second, results, prefix);
        first.addFirst(headSecond);
    }
}
