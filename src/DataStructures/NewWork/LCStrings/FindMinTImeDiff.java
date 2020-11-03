package DataStructures.NewWork.LCStrings;

import java.util.Arrays;
import java.util.List;

public class FindMinTImeDiff {
    public static void main(String[] args) {
        String[] arr  = {"00:00","23:59","00:00", "10:00","22:59","00:03"};
        System.out.println(new FindMinTImeDiff().findMinDifference(Arrays.asList(arr)));
    }

    public int findMinDifference(List<String> timePoints) {
        //we can sort the data and compare each interval to find the min diff
        //just the special case is.. compare last index with the first index as well.. to see if they are close ( eg : 00:00 .... 23:58)

        //Since the number of elements are limited (24 * 60 == 1440) .. we can use bucket sort
        //ans compare the same way

        //not using int[] ...as we need to populate -1 to handle the case of 00:00
        //we convert time to mins
        boolean[] times = new boolean[24*60];
        int min = 1441, max = -1;
        for(String s : timePoints){
            int time = getTimeFromString(s);
            //check if we are seeing the same time again.. if yes..return 0
            if(times[time]) return 0;
            times[time] = true;
            min = Math.min(min, time);
            max = Math.max(max, time);
        }

        //0...min...max...1440
        //starting with taking difference of last time and first time
        int minDiff = 1440 - max + min;
        int prev = min;
        for(int i=min+1 ; i<=max ; i++){
            if(times[i]){
                minDiff = Math.min(minDiff, i - prev);
                prev = i;
            }
        }
        return minDiff;
    }

    private int getTimeFromString(String s){
        int time = 0;
        int r = 0;
        int num = 0;
        while(s.charAt(r) != ':'){
            num = num*10 + s.charAt(r) - '0';
            r++;
        }
        time = num*60;
        num = 0;
        r++;
        while(r < s.length()){
            num = num*10 + s.charAt(r) - '0';
            r++;
        }
        return time + num;
    }
}
