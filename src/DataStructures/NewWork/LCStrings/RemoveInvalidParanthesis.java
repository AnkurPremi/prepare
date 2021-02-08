package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParanthesis {
    public static void main(String[] args) {
        String s = "()())()";
        System.out.println(new RemoveInvalidParanthesis().removeInvalidParentheses(s));
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList();
        if (s.isEmpty()) return result;
        helper(s, 0, 0, '(', ')', result);
        return result;
    }

    private void helper(String s, int left, int right, char open, char closed, List<String> result) {
        int counter = 0;

        while (right < s.length() && counter >= 0) {
            if (s.charAt(right) == open) counter++;
            else if (s.charAt(right) == closed) counter--;
            right++;
        }

        if (counter >= 0) {
            String output = new StringBuilder(s).reverse().toString();
            if (open == '(') {
                helper(output, 0, 0, closed, open, result);
            } else {
                result.add(output);
            }
        } else {
            right--;

            for (int i = left; i <= right; i++) {
                if (s.charAt(i) == closed && (i == left || closed != s.charAt(i - 1))) {
                    helper(s.substring(0, i) + s.substring(i + 1, s.length()), i, right, open, closed, result);
                }
            }
        }
    }
}
