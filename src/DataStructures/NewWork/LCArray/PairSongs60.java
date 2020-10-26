package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;

public class PairSongs60 {
    public static void main(String[] args) {
        int[] arr = {60, 60, 60};
//        System.out.println(new PairSongs60().countNew(arr));
        System.out.println(new PairSongs60().numPairsDivisibleBy60(arr));
    }

    public int countNew(int[] arr){
        int c = 0;
        for(int i=0; i< arr.length-1; i++){
            for(int j=i+1; j < arr.length ; j++){
                if((arr[i] + arr[j]) %60 == 0)
                    c++;
            }
        }
        return c;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : time) {
            if (map.containsKey((60 - i % 60) % 60)) {
                count += map.get((60 - i % 60) % 60);
            }
            map.put(i%60, map.getOrDefault(i%60, 0) + 1);
        }
        return count;
    }
}
