package misc;

//https://leetcode.com/problems/minimum-cost-for-tickets/

//In a country popular for train travel, you have planned some train travelling one year in advance.
//        The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
//Train tickets are sold in 3 different ways:
//a 1-day pass is sold for costs[0] dollars;
//a 7-day pass is sold for costs[1] dollars;
//a 30-day pass is sold for costs[2] dollars.
//The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2,
//        then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
//Return the minimum number of dollars you need to travel every day in the given list of days.

public class MInCostTickets {
    public static void main(String[] args) {
        int[] days = {2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        System.out.println(mincostTickets1(days, costs));
    }

    //cost will be min of below three options
    //When u buy 1-day pass -> min cost yesterday + cost of 1-day pass
    //when u buy 7-day pass -> min cost 7 days back + cost of 7-day pass
    //when u buy 30-day pass -> min cost 30 days back + cost of 30-day pass
    static int mincostTickets(int[] days, int[] costs) {

        int firstDay = days[0];//we will use it to loop only for these days
        int lastDay = days[days.length - 1];//we will use it to loop only for these days
        int d = 0;
        int[] dp = new int[lastDay + 1];  //int[] dp = new int[366]; -- we don't need this big array we need the array to be big as last travel day
        for (int i = firstDay; i <= lastDay; i++) {
            if (i != days[d]) { //Non travel day..
                dp[i] = dp[i - 1]; // same as previous day cost.. no need to buy the tkt
            } else { //It's a travel day
                //find min of three options and move
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[Math.max(i - 7, 0)] + costs[1], dp[Math.max(i - 30, 0)] + costs[2]));
                d++;
            }
        }
        return dp[lastDay];
    }


    //we are using t
    static int mincostTickets1(int[] days, int[] costs) {

        int firstDay = days[0];//we will use it to loop only for these days
        int lastDay = days[days.length - 1];//we will use it to loop only for these days
        int d = 0;
        int[] dp = new int[31];  //since we are only checking max for last 30 days (when we buy 30 day pass)
        for (int i = firstDay; i <= lastDay; i++) {
            if (i != days[d]) { //Non travel day..
                dp[i % 30] = dp[(i - 1) % 30]; // same as previous day cost.. no need to buy the tkt
            } else { //It's a travel day
                //find min of three options and move
                dp[i % 30] = Math.min(dp[(i - 1) % 30] + costs[0],
                        Math.min(dp[Math.max(i - 7, 0) % 30] + costs[1],
                                dp[Math.max(i - 30, 0) % 30] + costs[2]));
                d++;
            }
        }
        return dp[lastDay % 30];
    }
}
