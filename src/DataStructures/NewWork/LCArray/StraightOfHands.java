package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class StraightOfHands {
    public static void main(String[] args) {
        int[] hand = {2, 1};
        int w = 2;
        System.out.println(new StraightOfHands().isNStraightHand(hand, w));
    }

    int[] hand;
    boolean[] visited;

    //O(W * 2^N)
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if(n % W != 0) return false;

        this.visited = new boolean[n];
        this.hand = hand;

        int grpCnt = n / W;

//         Arrays.sort(hand);

        return helper(W, 0, -1, grpCnt, 0);

    }

    private boolean helper(int w, int idx, int prev, int grpCnt, int grpSizeNow){
        if(grpCnt == 0) return true;

        if(w == grpSizeNow && helper(w, 0, -1, grpCnt - 1, 0)){
            return true;
        }

        for(int i = 0 ; i < hand.length ; i++){
            if(!visited[i] && (prev == -1 || hand[i] == prev + 1)){

                visited[i] = true;

                if(helper(w, i + 1, hand[i], grpCnt, grpSizeNow + 1)){
                    return true;
                }

                visited[i] = false;
            }
        }
        return false;
    }
}
