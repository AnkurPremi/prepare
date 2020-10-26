package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;

public class CanArrange {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,1,1,1,9,9,9,9};
        System.out.println(new CanArrange().canArrange(arr, 5));
    }

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            int num = i % k;
            if(num == 0){
                if(map.containsKey(0)){
                    map.put(0, map.get(0) - 1);
                    map.remove(0, 0);
                }else{
                    map.put(0, 1);
                }
                continue;
            }
            num = num < 0 ? num + k : num;
            int val = map.getOrDefault(k - num, 0);
            if (val == 0) {
                map.put(num, 1);
            } else {
                map.put(k - num, val - 1);
                map.remove(k - num, 0);
            }
        }
        return map.size() == 0;
    }
}
