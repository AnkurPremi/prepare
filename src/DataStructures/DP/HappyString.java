package DataStructures.DP;

import DataStructures.LCTrees.HasPathSum;

import java.util.PriorityQueue;

public class HappyString {
    public static void main(String[] args) {
        System.out.println(new HappyString().getHappyString(11, 1, 2));
    }

//    public String getHappyString(int a, int b, int c) {
//        return getHappyString(a, b, c, "a", "b", "c");
//    }
//
//    //first pick the elements from lg and md heap and arrange them to get the answer
//    //Always keep a >= b >= c. ( first 2 conditions)
//    public String getHappyString(int l, int m, int s, String lg, String md, String sm) {
//        if (l < m)
//            return getHappyString(m, l, s, md, lg, sm);
//        if (m < s)
//            return getHappyString(l, s, m, lg, sm, md);
//        if (m == 0)
//            return lg.repeat(Math.min(2, l));
//
//        int use_lg = Math.min(2, l);
//        int use_md = l - use_lg >= m ? 1 : 0;
//        return lg.repeat(use_lg) + md.repeat(use_md) + getHappyString(l - use_lg, m - use_md, s, lg, md, sm);
//    }

    public String getHappyString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((s1, s2) ->{
            return s2[1] - s1[1];
        });

        pq.offer(new int[]{0, a});
        pq.offer(new int[]{1, b});
        pq.offer(new int[]{2, c});

        StringBuilder builder = new StringBuilder();

        //try adding 1 char from larger heap..
        //if conditions don't meet .. means last 2 chars in String formed uptil now has the same character
        //then try adding 1 char from 2nd largest heap
        //break the loop - while doing above steps.. if large heap becomes 0 or 2nd large becomes 0
        while(true){

            int[] large = pq.poll();
            if(large[1] == 0)  break;

            char ch = (char)(large[0] + 'a');
            int n = builder.length();

            if(n < 2 || builder.charAt(n-2) != ch || builder.charAt(n-1) != ch){
                builder.append(ch);
                large[1]--;
            } else{
                if(!pq.isEmpty() && pq.peek()[1] == 0)
                    break;
                ch = (char)(pq.peek()[0] + 'a');
                builder.append(ch);
                pq.peek()[1]--;
            }

            pq.offer(large);
        }

        return builder.toString();
    }
}
