package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * count-of-smaller-numbers-after-self
 * eg:  Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 */
public class SmallerNumAfterSelf {

    public static void main(String[] args) {
        int[] input = {5, 2, 6, 1};
        System.out.println(input);
//        System.out.println(getSmallerAfterSelf(input));
        System.out.println("-------------------");
        int[] input1 = {10, 3, 9, 6, 4, 8};
        System.out.println(input1);
//        System.out.println(getSmallerAfterSelf(input1));
        int[] input2 = {26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
        System.out.println(getSmallerAfterSelf(input2));
    }

    /**
     * We will start traversing the input list from back
     * and start storing the elements into a BST
     * BST will contain the element and the number of elements smaller after self
     * Element going to the right will add 1 to the count after self
     *
     * @param inputList
     * @return
     */
    static List<Integer> getSmallerAfterSelf(int[] inputList) {
        List<Integer> opList = new ArrayList<>(inputList.length);
        int len = inputList.length;
        TreeNode head = new TreeNode(inputList[len - 1], 0);
        opList.add(0);
        for (int i = len - 2; i > -1; i--) {
            int element = inputList[i];
            TreeNode node = new TreeNode(element, 0);
            int elementsAfterSelf = addElementToTheTree(head, node);
            opList.add(elementsAfterSelf);
        }
        Collections.reverse(opList);
        return opList;
    }

    static int addElementToTheTree(TreeNode head, TreeNode toBeAddedNode) {
        if (toBeAddedNode.val == head.val) {
            //Add 1 to toBeAddedNode.elementsAfterSelf for duplicates ?????
            toBeAddedNode.elementsAfterSelf = head.elementsToLeft + toBeAddedNode.elementsAfterSelf;
        } else if (toBeAddedNode.val > head.val) {
            toBeAddedNode.elementsAfterSelf = head.elementsToLeft + toBeAddedNode.elementsAfterSelf + 1;
            if (head.right == null) {
                head.right = toBeAddedNode;
            } else {
                return addElementToTheTree(head.right, toBeAddedNode);
            }
        } else {
            head.elementsToLeft = head.elementsToLeft + 1;
            if (head.left == null) {
                head.left = toBeAddedNode;
            } else {
                return addElementToTheTree(head.left, toBeAddedNode);
            }
        }
        return toBeAddedNode.elementsAfterSelf;
    }
}

class TreeNode {
    int val;
    int elementsAfterSelf;
    int elementsToLeft;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val, int elementsAfterSelf) {
        this.elementsAfterSelf = elementsAfterSelf;
        this.val = val;
    }
}