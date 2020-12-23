package DataStructures.NewWork.Tree;

public class BinaryTreeFromInfixHard {
    public static void main(String[] args) {
        String s = "((5+7+8)*(8-7))*(6+2)";
        Node node = new BinaryTreeFromInfixHard().expTree(s);
        System.out.println("dsadadsa");
    }

    int i = 0;
    public Node expTree(String s) {
        return helper(s);
    }

    public Node helper(String s) {
        Node dummy = new Node('0');
        Node prev = dummy;
        int n = s.length();
        while (i < n) {
            if (Character.isDigit(s.charAt(i))) {
                Node node = new Node(s.charAt(i++));
                if (i < n && s.charAt(i) != ')') {
                    Node opNode = new Node(s.charAt(i++));
                    opNode.left = node;
                    prev.right = opNode;
                    prev = opNode;
                } else {
                    prev.right = node;
                    if ( i<n && s.charAt(i) == ')') {
                        i++;
                        return dummy.right;
                    }
                }
            } else if (s.charAt(i) == '(') {
                i++;
                Node node = helper(s);
                prev.right = node;
                if ( i<n && s.charAt(i) == ')') {
                    i++;
                    return dummy.right;
                }
                if (i < n && s.charAt(i) != ')') {
                    Node opNode = new Node(s.charAt(i++));
                    opNode.left = dummy.right;
                    dummy.right = opNode;
                    prev = opNode;
                }
            }
        }
        return dummy.right;
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
