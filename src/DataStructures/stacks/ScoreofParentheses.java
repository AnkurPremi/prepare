package DataStructures.stacks;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class ScoreofParentheses {
    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(new ScoreofParentheses().scoreOfParentheses(s));
        LinkedList<Integer> st = new LinkedList<Integer>();
    }

    public int scoreOfParentheses(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }
        return ans;
    }
}
