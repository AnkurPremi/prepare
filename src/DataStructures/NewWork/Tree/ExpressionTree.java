package DataStructures.NewWork.Tree;

public class ExpressionTree {
    public static void main(String[] args) {
        String s = "2-3/(2+(5*2))";
        Node node = new ExpressionTree().expTree(s);
    }

    int i = 0;
    public Node expTree(String s) {
        Node dummyHead = new Node('0');
        Node dummy = dummyHead;

        char num = ' ';
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;

            if (Character.isDigit(c)) {
                num = c;
            } else if (isOperator(c)) {
                Node node = new Node(c);
                node.left = new Node(num);
                dummy.right = node;
                dummy = dummy.right;
                num = ' ';
            } else if (c == '(') {
                Node node = expTree(s);
                dummy.right = node;
                if (i < s.length() && s.charAt(i) != ')') {
                    Node node1 = new Node(s.charAt(i));
                    node1.left = dummyHead.right;
                    dummyHead.right = node1;
                    dummy = dummyHead.right;
                    i++;
                }
            } else {
                dummy.right = new Node(num);
                num = ' ';
                break;
            }
        }
        if(num != ' '){
            dummy.right = new Node(num);
        }
        return dummyHead.right;
    }

    private boolean isOperator(char c) {
        return c == '*' || c == '/' || c == '+' || c == '-';
    }

    class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
