package DataStructures.NewWork.LCStrings;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalc {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)-(6+8)";
        System.out.println(new BasicCalc().calculate(s));
    }



    public int calculate(String s) {

        Deque<Integer> stack = new LinkedList<>();
        int r = 0;
        char[] arr = s.toCharArray();
        char prev = '+';
        while (r < arr.length) {
            if (arr[r] == ' ') {
                r++;
                continue;
            }
            if (Character.isDigit(arr[r])) {
                int num = 0;
                while (r < arr.length && Character.isDigit(arr[r])) {
                    num = num * 10 + arr[r] - '0';
                    r++;
                }
                if (prev == '-')
                    stack.addLast(-num);
                else
                    stack.addLast(num);
            } else if (arr[r] == '(') {
                if (prev == '-')
                    stack.addLast(-1);
                else
                    stack.addLast(1);

                stack.addLast(null);
                prev = '+';
                r++;
            } else if (arr[r] == ')') {
                int num = 0;
                int mult = 1;
                while (!stack.isEmpty() && stack.peekLast() != null) {
                    num += stack.pollLast();
                }
                if (!stack.isEmpty() && stack.peekLast() == null) {
                    stack.pollLast();
                    mult = stack.pollLast();
                }
                stack.addLast(mult*num);
                r++;
            } else {
                prev = arr[r];
                r++;
            }
        }

        int num = 0;
        while (!stack.isEmpty() && stack.peekLast() != null) {
            num += stack.pollLast();
        }
        return num;
    }
}
