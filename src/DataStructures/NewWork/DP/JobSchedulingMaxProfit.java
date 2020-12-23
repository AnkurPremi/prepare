package DataStructures.NewWork.DP;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class JobSchedulingMaxProfit {
    public static void main(String[] args) {
        int[] st = {1, 2, 3, 4, 6};
        int[] et = {3, 5, 10, 6, 9};
        int[] p = {20, 20, 100, 70, 60};
        System.out.println(new JobSchedulingMaxProfit().addStrings("10", "899"));
        System.out.println(new JobSchedulingMaxProfit().jobScheduling(st, et, p));
    }


    //Very similar to Meeting Rooms 2 and Course Schedule 3
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for(int i=0 ; i<n ; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) ->{
            return a.end - b.end;
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0); // just to handle empty data issue
        for(Job job : jobs){
            // check if we can add this job
            // Step 1 - check if there exist a job that we previously did with its end time less than current job start time
            // Step 2 - If there exist a job, then check if doing current job along with the previous job will give more profit   than doing last job
            //Step 3 - if yes, add the current job to the map..
            //since the data is sorted from last time .. we just checked if we should do current job or not for maximizing the profit.
            int curVal = map.floorEntry(job.start).getValue() + job.profit;
            if(curVal > map.lastEntry().getValue()){
                map.put(job.end, curVal);
            }
        }
        return map.lastEntry().getValue();
    }

    class Job{
        int start, end, profit;
        public Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

//    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//        int[][] combine = new int[startTime.length][3];
//        for (int i = 0; i < startTime.length; i++) {
//            combine[i] = new int[]{startTime[i], endTime[i], profit[i]};
//        }
//        Arrays.sort(combine, (a, b) -> a[1] - b[1]);
//
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.put(0, 0);
//        int ans = 0;
//
//
//        for(int[] arr : combine){
//
//        }
//
//        for (int[] curr : combine) {
//            Integer prev = map.floorKey(curr[0]);
//            int prevSum = prev == null ? 0 : map.get(prev);
//            ans = Math.max(ans, prevSum + curr[2]);
//            map.put(curr[1], ans);
//        }
//        return ans;
//    }

    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length())
            return addStrings(num2, num1);

        int n = num1.length(), m = num2.length();

        int[] arr = new int[n+1];

        int writer = n;
        int num = 0;
        int car = 0;
        while(n-1 >= 0 || m-1 >= 0){
            if(n-1 >= 0){
                num += num1.charAt(n-1) - '0';
                n--;
            }

            if(m-1 >= 0){
                num += num2.charAt(m-1) - '0';
                m--;
            }

            num += car;
            arr[writer--] = num%10;
            car = num/10;
            num=0;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=writer+1 ; i<num1.length()+1 ; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
