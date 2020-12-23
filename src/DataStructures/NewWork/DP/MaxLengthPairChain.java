package DataStructures.NewWork.DP;

import java.util.TreeMap;

public class MaxLengthPairChain {
    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        System.out.println(new MaxLengthPairChain().findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int[] arr : pairs)
            map.put(arr[0], arr[1]);

        int max = 0;
        for(int[] arr : pairs){
            int maxHere = 1;
            Integer ceiling = map.ceilingKey(arr[1]);
            while(ceiling != null){
                maxHere++;
                ceiling = map.ceilingKey(map.get(ceiling));
            }
            max = Math.max(max, maxHere);
            if(max == pairs.length) return max;
        }

        return max;
    }
}
