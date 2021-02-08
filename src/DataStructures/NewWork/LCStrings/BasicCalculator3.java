package DataStructures.NewWork.LCStrings;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator3 {
    public static void main(String[] args) {
        String s = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(new BasicCalculator3().calculate(s));
    }

    int i = 0;
    public int calculate(String s) {
        Deque<Integer> numStack = new LinkedList();
        Deque<Character> charStack = new LinkedList();
        int num = 0;
        int n = s.length();
        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                helper(numStack, charStack, num);
                num = 0;
            } else if (c == '(') {
                i++;
                num = calculate(s);
                helper(numStack, charStack, num);
                num = 0;
            } else if (c == ')') {
                i++;
                break;
            } else if (c == ' ') {
                i++;
                continue;
            } else {
                i++;
                charStack.addLast(c);
            }
        }

        while (!numStack.isEmpty()) {
            if (!charStack.isEmpty()) {
                char operator = charStack.pollFirst();
                int num1 = numStack.pollFirst();
                int num2 = numStack.pollFirst();
                num1 = operator == '+' ? num1 + num2 : num1 - num2;
                numStack.addFirst(num1);
            } else{
                break;
            }
        }
        return numStack.pollFirst();
    }

    private void helper(Deque<Integer> numStack, Deque<Character> charStack, int num){
        if (!charStack.isEmpty()) {
            char operator = charStack.peekLast();
            if (operator == '*' || operator == '/') {
                operator = charStack.pollLast();
                int num2 = numStack.pollLast();
                num = operator == '*' ? num * num2 : num2 / num;
            }
        }
        numStack.addLast(num);
    }
}
