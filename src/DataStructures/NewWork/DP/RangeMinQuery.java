package DataStructures.NewWork.DP;

public class RangeMinQuery {
    public static void main(String[] args) {
        int[] nums = {-1,2,-3,4,5,-6,5,7,-8,9,5,40,-2,-3,-100};
        RangeMinQuery rangeMinQuery = new RangeMinQuery();
        rangeMinQuery.input(nums);
        System.out.println(rangeMinQuery.query(2,5));
        System.out.println(rangeMinQuery.query(1,3));
        rangeMinQuery.update(3,-5);
        System.out.println(rangeMinQuery.query(2,5));
        System.out.println(rangeMinQuery.query(2,10));
    }

    class SegmentTreeNode {
        int min;
        int start, end;
        SegmentTreeNode left, right;

        SegmentTreeNode(int s, int e) {
            start = s;
            end = e;
        }
    }

    SegmentTreeNode root = null;

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;

        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.min = nums[start];
        } else {
            int mid = (start + end) >> 1;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.min = Math.min(node.left.min, node.right.min);
        }
        return node;
    }

    public void input(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private void update(SegmentTreeNode root, int start, int val) {
        if (root.start == root.end)
            root.min = val;
        else {
            int mid = (root.start + root.end) >> 1;
            if (start <= mid) {
                update(root.left, start, val);
            } else {
                update(root.right, start, val);
            }
            root.min = Math.min(root.left.min, root.right.min);
        }
    }

    public void update(int i, int val) {
        update(root, i, val);
    }


    private int findMin(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.min;
        }
        int mid = (root.start + root.end) >> 1;
        if (end <= mid)
            return findMin(root.left, start, end);
        else if (start >= mid + 1)
            return findMin(root.right, start, end);
        else {
            return Math.min(findMin(root.left, start, mid), findMin(root.right, mid + 1, end));
        }
    }

    public int query(int i, int j){
        return findMin(root, i, j);
    }
}
