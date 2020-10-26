package DataStructures.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCells {
    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};
        int n = 1000000009;
        System.out.println(new PrisonCells().prisonAfterNDays(cells, n));
    }

//
//    Since you only have 6 bits that are changing (first and last bit changes to 0 and stays 0). Total max possible distinct states are 2 ^ 6 = 64.
//
//    Let's take an example. Assume you are asked the state after 10 ^ 9 days.
//    You store the state in the map the first time you see a new state. Then when you see the same state again, you know that you have passed (lastSeen - currVal) state in between. So now you know your states repeat every (lastSeen - currVal) times. So finally you can mod the current N with that value to not repeat the same steps. Below is an example for 10^9 days.
//[0,1,0,1,1,0,0,1]
//        1000000000
//
//    N -> N % (last_seen - curr_val) ==> result
//999999985 -> 999999985 % (999999999 - 999999985) ==> 5
//        4 -> 4 % (999999998 - 4) ==> 4
//        3 -> 3 % (999999997 - 3) ==> 3
//        2 -> 2 % (999999996 - 2) ==> 2
//        1 -> 1 % (999999995 - 1) ==> 1
//        0 -> 0 % (999999994 - 0) ==> 0

    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            int[] cells2 = new int[8];
            String s  = Arrays.toString(cells);
            System.out.print("Finding this first time : " + s);
            System.out.println("         At N: "+ N);
            seen.put(s, N--);
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
            if (seen.containsKey(Arrays.toString(cells))) {
                String s1 = Arrays.toString(cells);
                System.out.print("Seen this earlier: " + s1);
                System.out.println("                At N: " + seen.get(s1));
                N %= seen.get(s1) - N;
                System.out.println("New N: " + N);
            }
        }
        return cells;
    }
}
