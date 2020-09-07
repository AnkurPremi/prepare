package problemsArray;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarThree_3 {
    public static void main(String[] args) {
        MyCalendarThree calendar = new MyCalendarThree();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(50, 60));
        System.out.println(calendar.book(10, 40));
        System.out.println(calendar.book(5, 15));
        System.out.println(calendar.book(5, 10));
        System.out.println(calendar.book(25, 55));
    }
}
class MyCalendarThree {
    TreeMap<Integer,Integer> map = null;
    public MyCalendarThree() {
        map = new TreeMap<Integer,Integer>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start,0) + 1);
        map.put(end, map.getOrDefault(end,0) - 1);
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            count += entry.getValue();
            max = Math.max(max, count);
        }
        return max;
    }
}
