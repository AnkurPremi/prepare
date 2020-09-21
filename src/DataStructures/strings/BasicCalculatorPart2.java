package DataStructures.strings;

import java.util.Stack;

public class BasicCalculatorPart2 {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
//        s = "2-(5-6)";
//        s = "(5-(1+(5)))";
//        s = "5+3-4-(1+2-7+(10-1+3+5+(3-0+(8-(3+(8-(10-(6-10-8-7+(0+0+7)-10+5-3-2+(9+0+(7+(2-(2-(9)-2+5+4+2+(2+9+1+5+5-8-9-2-9+1+0)-(5-(9)-(0-(7+9)+(10+(6-4+6))+0-2+(10+7+(8+(7-(8-(3)+(2)+(10-6+10-(2)-7-(2)+(3+(8))+(1-3-8)+6-(4+1)+(6))+6-(1)-(10+(4)+(8)+(5+(0))+(3-(6))-(9)-(4)+(2))))))-1)))+(9+6)+(0))))+3-(1))+(7))))))))";
        int a = calculate1(s);
        System.out.println(a);
    }


    public static int calculate(String s) {
        int result = 0;
        try {
            while (s.indexOf('(') != -1 && s.indexOf(')') != -1) {
                int end = s.indexOf(")");
                int start = s.substring(0, end).lastIndexOf("(");
                int val = calculate(s.substring(start + 1, end));
                if (end < s.length()) {
                    if (val < 0) {
                        if (start - 1 >= 0 && s.charAt(start - 1) == '-') {
                            val = val * -1;
                            s = s.substring(0, start - 1) + '+' + val + s.substring(end + 1);
                        } else {
                            s = val + s.substring(end + 1);
                        }
                    } else {
                        try {
                            s = s.substring(0, start) + val + s.substring(end + 1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (s.indexOf('+') == -1 && s.indexOf('-') == -1) return Integer.valueOf(s);
            int num = 0;
            char op = '+';
            s += '+';
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                    continue;
                }
                if (c == ' ') continue;
                if (op == '+') stack.push(num);
                else if (op == '-') stack.push(-num);
                num = 0;
                op = c;
            }
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int result = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * num;
                result = result * stack.pop();//multiply sign outside the bracket to the result inside the bracket
                result = result + stack.pop();//add the numbers, outside number and number inside bracket
                num = 0;
            }
        }
        if(num != 0) result += sign * num;
        return result;
    }

}
