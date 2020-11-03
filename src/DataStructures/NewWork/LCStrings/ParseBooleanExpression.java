package DataStructures.NewWork.LCStrings;

import java.util.Deque;
import java.util.LinkedList;

public class ParseBooleanExpression {
    public static void main(String[] args) {
        String s = "!(f)";
        System.out.println(new ParseBooleanExpression().parseBoolExpr(s));
    }

    public boolean parseBoolExpr(String s) {
        Deque<Boolean> boDq = new LinkedList<>();
        Deque<Character> operDq = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ',') continue;

            if (c == 'f' || c == 't') {
                boDq.addLast(c == 'f' ? false : true);
            } else if (c == '(') {
                boDq.addLast(null);
            } else if (c == '!' || c == '|' || c == '&') {
                operDq.addLast(c);
            } else {
                calculate(boDq, operDq.pollLast());
            }
        }
        return boDq.pollLast();
    }

    private void calculate(Deque<Boolean> boDq, char operand) {
        while (!boDq.isEmpty() && boDq.peekLast() != null) {
            boolean a = boDq.pollLast();
            if (boDq.peekLast() == null) {
                boDq.pollLast();
                if(operand == '!')
                    boDq.addLast(!a);
                else
                    boDq.addLast(a);
                return;
            }
            boolean b = boDq.pollLast();
            boolean result = operation(a, b, operand);
            boDq.addLast(result);
        }

        //remove null or '('
        boDq.pollLast();
    }

    private boolean operation(boolean a, boolean b, char c) {
        switch (c) {
            case '&':
                return a && b;
            case '|':
                return a || b;
        }
        return true;
    }
}
