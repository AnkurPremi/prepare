package DataStructures.DP;

import java.util.LinkedList;
import java.util.Queue;

public class TrainTickets {
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(new TrainTickets().mincostTickets(days, costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        Queue<int[]> q7Days = new LinkedList<>();
        Queue<int[]> q30Days = new LinkedList<>();

        int totalcost = 0;
        for(int i=0; i<days.length ; i++){

            //check if the 7 days pass is expired
            while(!q7Days.isEmpty() && q7Days.peek()[0] + 7 <= days[i]){
                q7Days.poll();
            }
            //add pass with previous cost + 7 days pass cost
            q7Days.offer(new int[]{days[i], totalcost + costs[1]});


            //check if the 30 days pass is expired
            while(!q30Days.isEmpty() && q30Days.peek()[0] + 30 <= days[i]){
                q30Days.poll();
            }
            //add pass with previous cost + 7 days pass cost
            q30Days.offer(new int[]{days[i], totalcost + costs[2]});

            //finally calculate the final low cost for the day + previous cost
            totalcost = Math.min(totalcost + costs[0], Math.min(q7Days.peek()[1], q30Days.peek()[1]));
        }
        return totalcost;
    }

}
