package DataStructures.LCTrees;

public class NextNodePtrTree {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        Node result = new NextNodePtrTree().connect(node);
        System.out.println("dasad");
    }

    public Node connect(Node root) {
        if(root == null) return root;

        if(root.left != null)
        root.left.next = root.right;
        if(root.right != null && root.next != null)
            root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);

        return root;

    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
