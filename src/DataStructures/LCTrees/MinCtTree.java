package DataStructures.LCTrees;

import java.util.Stack;

public class MinCtTree {
    public static void main(String[] args) {
        int[] arr = {6,4,2,4};
        System.out.println(new MinCtTree().mctFromLeafValues(arr));
    }
    public int mctFromLeafValues(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
