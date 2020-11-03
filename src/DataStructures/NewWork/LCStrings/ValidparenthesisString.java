package DataStructures.NewWork.LCStrings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidparenthesisString {
    public static void main(String[] args) {
        String s = "()*()(()(*()(((())()()())*))()*()(*)(((*))(())(())((*()*(()(())()*(((*(**))((())*)(((()()))(())()))";
        System.out.println(new ValidparenthesisString().checkValidString(s));
    }

    public boolean checkValidString(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '*')
                count++;

            else if (s.charAt(i) == '(')
                stack.addLast(i);

            else {
                if (!stack.isEmpty()) {
                    stack.pollLast();

                } else if (count > 0) {
                    count--;
                } else
                    return false;
            }
        }
        int prev = -1;
        while (!stack.isEmpty()) {
            if (stack.size() > count)
                return false;
            int idx = stack.pollFirst();
            boolean found = false;
            for (int i = Math.max(idx, prev); i < s.length(); i++) {
                if (s.charAt(i) == '*') {
                    prev = i + 1;
                    count--;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }

        return true;
    }
}
