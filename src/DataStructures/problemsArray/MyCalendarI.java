package DataStructures.problemsArray;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-i/
public class MyCalendarI {
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 20));
        System.out.println(calendar.book(20, 30));
        System.out.println(calendar.book(1, 17));
    }
}


class MyCalendar {

    //This problem can be solved using TreeMap properties
    //1st - keys are sorted..searching is O(logN)
    //2nd - insert is O(1)
    //3rd - we have functions floorKey and ceilingKey
    //Before putting any pair into map.. we will check if the floor corresponding to the start index of the pair being inserted
    //lies in the range of floors pair

    TreeMap<Integer,Integer> map = null;

    public MyCalendar() {
        map = new TreeMap<Integer,Integer>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start,0) + 1);
        map.put(end, map.getOrDefault(end,0) - 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            count += entry.getValue();
            if(count > 1){
                map.put(start, map.getOrDefault(start,0) - 1);
                map.remove(start, 0);
                map.put(end, map.getOrDefault(end,0) + 1);
                map.remove(end, 0);
                return false;
            }
        }
        return true;
    }
}

//class MyCalendar {
//
//    //This problem can be solved using TreeMap properties
//    //1st - keys are sorted..searching is O(logN)
//    //2nd - insert is O(1)
//    //3rd - we have functions floorKey and ceilingKey
//    //Before putting any pair into map.. we will check if the floor corresponding to the start index of the pair being inserted
//    //lies in the range of floors pair
//
//    TreeMap<Integer,Integer> map = null;
//
//    public MyCalendar() {
//        map = new TreeMap<Integer,Integer>();
//    }
//
//    public boolean book(int start, int end) {
//        Integer floor = map.floorKey(start);
//        Integer ceiling = map.ceilingKey(start);
//           // here floor comparison will determine that the start value is greater than already inserted pair
//            //ceiling will determine that the end value doesn't lie in any of the pair
//        if((floor == null || map.get(floor) <= start) && (ceiling == null || end <= ceiling)){
//            map.put(start, end);
//            return true;
//        }
//        return false;
//    }
//}