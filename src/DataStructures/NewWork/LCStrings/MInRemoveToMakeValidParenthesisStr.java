package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.List;

public class MInRemoveToMakeValidParenthesisStr {
    public static void main(String[] args) {
        String s = "a(b)c)(";
        System.out.println(new MInRemoveToMakeValidParenthesisStr().minRemoveToMakeValid(s));
    }

    public String minRemoveToMakeValid(String s) {
        List<Integer> badIndices = new ArrayList<>();
        int l = 0, r = s.length() - 1;
        int lc = 0, rc = 0;
        while (l <= r) {
            if (s.charAt(l) == ')' && lc == 0) {
                badIndices.add(l);
                l++;
            } else if (s.charAt(l) == '(') {
                if (lc == 0) lc++;
                if (rc == 1) {
                    rc--;
                    lc++;
                    r--;
                    l++;
                }
            } else {
                l++;
            }

            if (s.charAt(r) == '(' && rc == 0) {
                badIndices.add(r);
                r--;
            } else if (s.charAt(r) == ')') {
                if (rc == 0) rc++;
                if (lc == 1) {
                    rc--;
                    lc++;
                    r--;
                    l++;
                }
            } else {
                r--;
            }
        }
        return "";
    }
}
