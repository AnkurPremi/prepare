package DataStructures.stacks;

import DataStructures.NewWork.LCStrings.StringCanBreak;

public class ScoreofParentheses {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(new ScoreofParentheses().scoreOfParentheses(s));
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
