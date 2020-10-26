package DataStructures.BinarySearch;

import java.util.TreeMap;

public class FindRightIntervals {
    public static void main(String[] args) {
        int[][] ar = {{1,4},{2,3},{3,4}};
        System.out.println(new FindRightIntervals().findRightInterval(ar));
    }

    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, int[]> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], new int[]{intervals[i][1], i});
            result[i] = -1;
        }
        int j = 0;
        for (int[] arr : intervals) {
//            if (map.containsKey(arr[1])) {
//                result[j++] = map.get(arr[1])[1];
//            }else {
                Integer num = map.ceilingKey(arr[1]);
                if (num == null)
                    j++;
                else
                    result[j++] = map.get(num)[1];
//            }
        }
        return result;
    }
}
