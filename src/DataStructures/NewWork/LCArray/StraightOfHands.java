package DataStructures.NewWork.LCArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StraightOfHands {
    public static void main(String[] args) {
        int[] hand = {1,2,3};
        int w = 1;
        System.out.println(new StraightOfHands().isNStraightHand(hand, w));
    }

//    int[] hand;
//    boolean[] visited;
//
//    //O(W * 2^N)
//    public boolean isNStraightHand(int[] hand, int W) {
//        int n = hand.length;
//        if(n % W != 0) return false;
//
//        this.visited = new boolean[n];
//        this.hand = hand;
//
//        int grpCnt = n / W;
//
////         Arrays.sort(hand);
//
//        return helper(W, 0, -1, grpCnt, 0);
//
//    }
//
//    private boolean helper(int w, int idx, int prev, int grpCnt, int grpSizeNow){
//        if(grpCnt == 0) return true;
//
//        if(w == grpSizeNow && helper(w, 0, -1, grpCnt - 1, 0)){
//            return true;
//        }
//
//        for(int i = 0 ; i < hand.length ; i++){
//            if(!visited[i] && (prev == -1 || hand[i] == prev + 1)){
//
//                visited[i] = true;
//
//                if(helper(w, i + 1, hand[i], grpCnt, grpSizeNow + 1)){
//                    return true;
//                }
//
//                visited[i] = false;
//            }
//        }
//        return false;
//    }

//    public boolean isNStraightHand(int[] hand, int W) {
//        int n = hand.length;
//        if (n % W != 0) return false;
//        int count = n / W;
//
//        Map<Integer, Integer> map = new HashMap();
//        for (int num : hand) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 0) continue;
//            int key = entry.getKey();
//            int keyHere = key;
//            int valHere = entry.getValue();
//            for (int i = 0; i < valHere; i++) {
//                int temp = W - 1;
//                while (temp > 0) {
//                    if (!map.containsKey(key + 1) || map.get(key + 1) == 0) return false;
//                    key = key + 1;
//                    map.put(key, map.get(key) - 1);
//                    temp--;
//                }
//                count--;
//                map.put(keyHere, map.get(keyHere) - 1);
//                key = keyHere;
//                if (count == 0) return true;
//            }
//            map.put(keyHere, 0);
//        }
//
//        return count == 0;
//    }

    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if(n % W != 0) return false;

        int[] arr = hand.clone();
        Arrays.sort(arr);
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == -1) continue;
            int start = arr[i];
            arr[i] = -1;
            int count = W - 1;
            if(count != 0) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] != -1 && arr[j] == start + 1) {
                        count--;
                        arr[j] = -1;
                        start += 1;
                        if (count == 0) {
                            break;
                        }
                    }
                }
            }
            if(count != 0) return false;
        }
        return true;
    }
}
