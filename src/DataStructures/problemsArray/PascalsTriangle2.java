package DataStructures.problemsArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle-ii/
public class PascalsTriangle2 {
    public static void main(String[] args) {
        System.out.println(new PascalsTriangle2().getRow(5));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) result.add(1);
        else if (rowIndex == 1) result.addAll(Arrays.asList(1, 1));
        else {
            int[] arr = new int[rowIndex + 1];
            arr[0] = 1;
            arr[1] = 1;
            for (int i = 2; i <= rowIndex; i++) {
                int start = 0, end = 1, j = 1, preStart = arr[start];
                for (; j < i; j++) {
                    int prevEnd = arr[end];
                    arr[j] = preStart + arr[end];
                    end++;
                    preStart = prevEnd;
                }
                arr[0] = 1;
                arr[j] = 1;
            }
            for(int i : arr){
                result.add(i);
            }
        }
        return result;
    }
}
