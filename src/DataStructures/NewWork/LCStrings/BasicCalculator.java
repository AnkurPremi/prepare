package DataStructures.NewWork.LCStrings;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new BasicCalculator().calculate(s));
    }

    public int calculate(String s) {
        return helper(s, new int[]{0});
    }

    private int helper(String s, int[] idx){
        int i = idx[0];
        int result = 0;
        int sign = 1;
        int num = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            i++;

            if(c == ' '){
                continue;
            } else if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            } else if(c == '('){
                idx[0] = i;
                num = helper(s, idx);
                i = idx[0];
            } else if(c == ')'){
                break;
            } else {
                result += sign * num;
                sign = c == '+' ? 1 : -1;
                num = 0;
            }

        }
        idx[0] = i;
        return result + (sign * num);
    }

//    int i;
//
//    public int calculate(String s) {
//
//        int operand = 0;
//        int result = 0; // For the on-going result
//        int nextOperandSign = 1;  // 1 means positive, -1 means negative
//
//        while(i < s.length()) {
//
//            char ch = s.charAt(i);
//            i++;
//            if (ch == ' ' || Character.isDigit(ch)) {
//                operand = (ch == ' ') ? operand : 10 * operand + (ch - '0');
//
//            } else if (ch == '(') {
//                operand = calculate(s);
//
//            } else if (ch == ')') {
//                break; // Sub-expression we were evaluating has ended. Exit now...
//
//            } else {
//                // If we're here, we just read the operator for the next operand/expression.
//                // Evaluate the existing expression already read, reset operand, set sign for next incoming operand.
//                result += nextOperandSign * operand;
//                nextOperandSign = ch == '+' ? 1 : -1;
//                operand = 0;
//            }
//        }
//
//        return result + (nextOperandSign * operand);
//    }

//    public int calculate(String s) {
//        int sign = 1;
//        Stack<Integer> stack = new Stack();
//        stack.push(sign);
//        int num = 0;
//        int result = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (isDigit(c)) {
//                num = num * 10 + c - '0';
//
//            } else if (c == '+' || c == '-') {
//                result += sign * num;
//                sign = stack.peek() * (c == '+' ? 1 : -1);
//                num = 0;
//            } else if (c == '(') {
//                stack.push(sign);
//            } else if (c == ')') {
//                stack.pop();
//            }
//        }
//        result += sign * num;
//        return result;
//    }
//
//    private boolean isDigit(char c) {
//        return c >= '0' && c <= '9';
//    }
//
//    private boolean isSpace(char c) {
//        return c == ' ';
//    }
}
