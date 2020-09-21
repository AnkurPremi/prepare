package DataStructures.problemsArray;

public class JumpGameIII {
    public static void main(String[] args) {
        int[] arr = {3,0,2,1,2};
        System.out.println(new JumpGameIII().canReach(arr, 2));
    }

    public boolean canReach(int[] arr, int start) {
        if (start > arr.length - 1 || start < 0 || arr[start] == -1) return false;
        if (arr[start] == 0) return true;
        int temp = arr[start];
        arr[start] = -1;
        boolean left = canReach(arr, start - temp);
        if (left) return true;
        boolean right = canReach(arr, start + temp);
        arr[start] = temp;
        return right;
    }
}
