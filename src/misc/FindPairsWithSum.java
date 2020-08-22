package misc;

import java.util.HashMap;
import java.util.Map;

public class FindPairsWithSum {
    public static void main(String[] args) {
        int[] arr = {10, 2, 11, 19, 1, 18, 13};
        findPair(arr, 20);
    }

    static void findPair(int[] arr, int sum) {
        //map will contain the number & its sum compliment
        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(pairMap.get(arr[i]) == null){
                pairMap.put(sum-arr[i], arr[i]);
            }else {
                System.out.println(arr[i]+"--"+ pairMap.get(arr[i]));
            }
        }

    }
}
