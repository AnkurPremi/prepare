package DataStructures.NewWork.Tree;

import DataStructures.Trees.TreeNode;

import java.util.Stack;

public class StringToTree {
    public static void main(String[] args) {
        String s = "-4(2()(1))(6(5)(7))";
        TreeNode ans = new StringToTree().str2tree(s);
    }

    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        boolean found = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                sign = -1;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                found = true;
            } else if (c == '(' || c == ')') {
                if (found) {
                    TreeNode node = new TreeNode(sign * num);
                    sign = 1;
                    num = 0;
                    if (!stack.isEmpty()) {
                        if (stack.peek().left == null)
                            stack.peek().left = node;
                        else
                            stack.peek().right = node;
                    }
                    found = false;
                    stack.push(node);
                    if (c == ')') stack.pop();
                }
            }
        }
        while (stack.size() > 1) stack.pop();
        return stack.pop();
    }
}
