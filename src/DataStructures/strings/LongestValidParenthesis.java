package DataStructures.strings;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String input = "(()(()())))";
//        input = "()()";
        System.out.println(longestValidParentheses1(input));
    }

    public static int longestValidParentheses(String s) {
        int maxSize = 0;
        int left = -1;
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    left = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxSize = Math.max(maxSize, i - left);
                    } else {
                        maxSize = Math.max(maxSize, i - stack.peek());
                    }
                }
            }
        }
        return maxSize;
    }

    public static int longestValidParentheses1(String s) {
        char[] S = s.toCharArray();
        int[] V = new int[S.length];
        int open = 0;
        int max = 0;
        for (int i=0; i<S.length; i++) {
            if (S[i] == '(') open++;
            else if (S[i] == ')' && open > 0) {
                // matches found
                V[i] = 2+ V[i-1];
                // add matches from previous
                if(i-V[i]>0)
                    V[i] += V[i-V[i]];
                open--;
            }
            if (V[i] > max) max = V[i];
        }
        return max;
    }
}
