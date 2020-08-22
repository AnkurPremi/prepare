package strings;

import java.util.Stack;
// in relation to https://leetcode.com/problems/basic-calculator-iv/
public class BasicCalculator {
    public static void main(String[] args) {
        String s = " 31+  2  /2 +3 * 12 / 12  ";
        System.out.println(calulateFinal(s));
    }

    /**
     * one approach would be to find the '/' and start moving left and right to find the numbers on which operation needs to be applied
     * after that replace that whole string with the answer
     * Second approach would be to use the stack and check the operator precedence
     *
     * @param s
     * @return
     */

    public static int calulateFinal(String s){
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        s += '+';
        char op = '+';
        for (int i = 0, n = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                n = n * 10 + c - '0';
                continue;
            }
            if (c == ' ') continue;
            if (op == '+') stack.push(n);
            else if (op == '-') stack.push(-n);
            else if (op == '*') stack.push(stack.pop()*n);
            else if (op == '/') stack.push(stack.pop()/n);
            op = c;
            n = 0;
        }

        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
    }

}
