package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;

public class CanFormArray {
    public static void main(String[] args) {

        int[] arr = {49,18,16};
        int[][] pieces = {{16,18,49}};
        System.out.println(new CanFormArray().canFormArray(arr, pieces));
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < pieces.length; i++) {
            for (int num : pieces[i]) {
                map.put(num, i);
                break;
            }
        }

        int i = 0;
        while (i < arr.length) {
            if (!map.containsKey(arr[i])) return false;

            int idx = map.get(arr[i]);

            for (int j = 0; j < pieces[idx].length; j++) {
                if (arr[i] != pieces[idx][j]) return false;
                i++;
            }
        }

        return true;
    }
}
