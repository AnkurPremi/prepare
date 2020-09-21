package DataStructures.stacks;

import java.util.LinkedList;

public class RemoveAdjacentDupStr2 {
    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";
        new RemoveAdjacentDupStr2().removeDuplicates(s, 2);
    }

    public String removeDuplicates(String s, int k) {
        LinkedList<Element> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peekLast().cr == c && stack.peekLast().count == k - 1) {
                int j = k - 1;
                while (j-- > 0) {
                    stack.pollLast();
                }
                continue;
            }
            if (stack.isEmpty() || stack.peekLast().cr != c) {
                stack.offerLast(new Element(c, 1));
            } else {
                stack.offerLast(new Element(c, stack.peekLast().count + 1));
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pollFirst().cr);
        }
        return builder.toString();
    }

    class Element {
        char cr;
        int count;

        Element(char c, int count) {
            this.cr = c;
            this.count = count;
        }
    }
}
