package DataStructures.NewWork.SegmentTrees;

public class MyCalendar_1 {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 15));
        System.out.println(myCalendar.book(5, 10));
        System.out.println(myCalendar.book(20, 25));
        System.out.println(myCalendar.book(12, 17));
    }


}

class MyCalendar {
    TreeNode root;
    public MyCalendar() {}

    public boolean book(int start, int end) {
        TreeNode node = new TreeNode(start, end);
        if(root == null){
            root = node;
            return true;
        }

        TreeNode tempNode = root;
        TreeNode prevNode = tempNode;
        while(tempNode != null){
            if(start > tempNode.start && start < tempNode.end) return false;
            else if(end > tempNode.start && end < tempNode.end) return false;
            else if(start <= tempNode.start && end >= tempNode.end) return false;
            else if(start >= tempNode.start && end <= tempNode.end) return false;

            prevNode = tempNode;
            if(end < tempNode.start){
                tempNode = tempNode.left;
            } else {
                tempNode = tempNode.right;
            }
        }
        if(end < prevNode.start){
            prevNode.left = node;
        } else{
            prevNode.right = node;
        }

        return true;
    }

    class TreeNode {
        int start, end;
        TreeNode left, right;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}