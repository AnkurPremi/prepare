package DataStructures.NewWork.LCStrings;

import java.util.Stack;

public class DecodeStrings {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(new DecodeStrings().decodeString(s));
    }

    public String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                numbers.push(num);
                num = 0;
                stack.push(builder);
                builder = new StringBuilder();
            } else if (c == ']') {
                int mult = numbers.pop();
                StringBuilder temp = builder;
                builder = stack.pop();
                while (mult-- > 0) {
                    builder.append(temp);
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
