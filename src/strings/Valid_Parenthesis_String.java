package strings;

import java.util.Stack;

public class Valid_Parenthesis_String {
    public static void main(String[] args) {
        String s = "(**))";
    }

    public boolean checkValidString(String s) {
        if (s == null) return false;
        else if (s.isEmpty()) return true;
        else {
            //cmin is the min number of close brackets ')' required to make the string valid
            //min val of cmin is 0
            //cmax is the max number of close brackets ')' required to make the string valid,
            //cmax can't be negative
            int cmin = 0, cmax = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    cmax++;
                    cmin++;
                } else if (c == ')') {
                    cmax--;
                    cmin--;
                } else {
                    cmax++; // if we take * as open bracket .. requirement of closed bracket is increased
                    cmin--; // if we take * as closed bracket .. requirement of closed bracket is decreased
                }
                //we have more close brackets which we actually can close
                // Currently, don't have enough open parentheses to match close parentheses-> Invalid
                // For example: ())(
                if (cmax < 0) return false;

                //if cmin<0, it means you have taken some extra '*' as ')' which has caused the current "state" to become invalid, i.e. no opening bracket is there to balance the closing bracket.
                //
                //Say, string is (**)
                //1st iteration, character: (:
                //cmin = 1, cmax = 1
                //( (
                //
                //2nd iteration, character: *:
                //cmin = 0, cmax = 2
                //() ((
                //
                //3rd iteration, character: *:
                //cmin = -1, cmax = 3
                //()) (((
                //
                //You can see that there's no opening bracket to balance the last closing bracket (actually '*'). So we'll ignore the extra closing bracket we put in there, by resetting cmin back to 0, i.e. take it as an empty character.
                //() (((
                //Considering * as empty string
                cmin = Math.max(cmin, 0);
            }
            //min num of closed braces required should be 0 at the end to prove the string is valid
            return cmin == 0;
        }
    }
}
