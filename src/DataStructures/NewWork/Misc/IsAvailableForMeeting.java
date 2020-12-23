package DataStructures.NewWork.Misc;

import java.util.TreeMap;

public class IsAvailableForMeeting {
    public static void main(String[] args) {
        int[][] meetings = {{1230, 1300}, {845, 900}, {1300, 1500}};
        IsAvailableForMeeting obj = new IsAvailableForMeeting();
        obj.meetingsSchedule(meetings);
        System.out.println(obj.isAvailable(915, 1215));
        System.out.println(obj.isAvailable(1500, 1800));
        System.out.println(obj.isAvailable(850, 1240));
        System.out.println(obj.isAvailable(2359, 2400));
    }

    TreeMap<Integer, Integer> map;
    public void meetingsSchedule(int[][] meetings){
        map = new TreeMap<>();
        for(int[] meeting : meetings){
            map.put(meeting[0], meeting[1]);
        }
    }

    public boolean isAvailable(int start, int end){
        Integer floor = map.floorKey(start);
        Integer ceiling = map.ceilingKey(start);
        if((floor == null || map.get(floor) <= start) && (ceiling == null || end <= ceiling)){
            return true;
        }
        return false;
    }
}
