package DataStructures.NewWork.LCArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayPartitionInto3 {
    public static void main(String[] args) {
        int[] arr = {10,-10,10,-10,10,-10,10,-10};
        System.out.println(new ArrayPartitionInto3().canThreePartsEqualSum(arr));
    }

    public boolean canThreePartsEqualSum(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if(map.containsKey(sum)){
                count++;
                if(count % 3 == 0 && i == A.length-1) return true;
            }
            map.put(sum, i);
        }
        if (sum % 3 != 0) return false;
        int idx1 = map.getOrDefault(sum / 3, -1);
        int idx2 = map.getOrDefault(2 * (sum / 3), -1);
        if (idx1 == -1 || idx2 == -1) return false;
        if (idx2 <= idx1) return false;
        return true;
    }
}
