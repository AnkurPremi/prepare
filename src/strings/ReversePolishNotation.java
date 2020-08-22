package strings;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int val = new ReversePolishNotation().evalRPN(tokens);
        System.out.println(val);
    }

    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        for (String s : tokens) {
            if (isOperator(s)) {
                long second = stack.pop();
                long first = stack.pop();
                long result = 0;
                switch (s) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Long.valueOf(s));
            }
        }
        return stack.pop().intValue();
    }

    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }
}
