package DataStructures.stacks;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NumberofAtoms {
    public static void main(String[] args) {
        String s = "(Cm39)5(Ga28Sb45Rb8)20(Bk13Fr29As)45";
        System.out.println(new NumberofAtoms().countOfAtoms(s));
    }

    public String countOfAtoms(String formula) {
        Stack<Element> stack1 = new Stack<>();
        Stack<Element> stack2 = new Stack<>();
        TreeMap<String, Integer> resultMap = new TreeMap<>();
        int i = 0;
        int n = formula.length();
        while (i < n) {
            char c = formula.charAt(i);
            i++;
            if (Character.isDigit(c)) {
                int num = 0;
                num = num * 10 + c - '0';
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + formula.charAt(i) - '0';
                    i++;
                }
                if (!stack1.peek().name.equals(")")) {
                    stack1.peek().count *= num;
                } else {
                    stack1.pop();
                    while (!stack1.peek().name.equals("(")) {
                        Element e = stack1.pop();
                        e.count *= num;
                        stack2.push(e);
                    }
                    stack1.pop();
                    while (!stack2.isEmpty()) {
                        stack1.push(stack2.pop());
                    }
                }
            } else if (c == ')' || c == '(') {
                stack1.push(new Element("" + c));
            } else {
                String s = "" + c;
                while (i < n && formula.charAt(i) - 'a' < 26 && formula.charAt(i) - 'a' >= 0) {
                    s += formula.charAt(i);
                    i++;
                }
                stack1.push(new Element(s));
            }
        }
        while (!stack1.isEmpty()) {
            Element e = stack1.pop();
            resultMap.put(e.name, resultMap.getOrDefault(e.name, 0) + e.count);
        }
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            builder.append(entry.getKey()).append(entry.getValue());
        }
        return builder.toString();
    }

    class Element {
        String name;
        int count;

        Element(String name) {
            this.name = name;
            this.count = 1;
        }
    }
}
