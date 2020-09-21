package DataStructures.problemsArray;

//https://leetcode.com/problems/duplicate-zeros/
public class DuplicateZeros {
    public static void main(String[] args) {
        int[] nums = {8,4,5,0,0,0,0,7};
        new DuplicateZeros().duplicateZeros(nums);
    }

    public void duplicateZeros(int[] arr) {
        int newLastIdx = arr.length - 1;
        for (int i = 0; i <= newLastIdx; i++) {
            if (arr[i] == 0) {
                newLastIdx -= 1;
            }
        }
        if (newLastIdx == arr.length - 1) return;
        boolean printNextElementZero = false;
        for (int i = arr.length - 1; i >= 0 && newLastIdx>=0; i--) {
            if (printNextElementZero) {
                arr[i] = 0;
                printNextElementZero = false;
                continue;
            }
            if (arr[newLastIdx] == 0) {
                printNextElementZero = true;
            }
            arr[i] = arr[newLastIdx];
            newLastIdx--;
        }
    }
}
