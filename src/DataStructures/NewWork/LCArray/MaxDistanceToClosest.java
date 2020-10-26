package DataStructures.NewWork.LCArray;

import java.util.TreeSet;

public class MaxDistanceToClosest {
    public static void main(String[] args) {
        int[] seats = {0, 0, 0, 0, 0, 1, 0};
        System.out.println(new MaxDistanceToClosest().maxDistToClosest(seats));
    }

    public int maxDistToClosest(int[] seats) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) set.add(i);
        }

        int max = 1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                Integer floor = set.floor(i);
                Integer ceiling = set.ceiling(i);
                if (floor == null) {
                    max = Math.max(ceiling.intValue() - i, max);
                    i = ceiling.intValue()+1;
                } else if (ceiling == null) {
                    max = Math.max(seats.length - 1 - floor.intValue(), max);
                    return max;
                } else {
                    max = Math.max(max, Math.min(ceiling.intValue() - i, i - floor.intValue()));
                }
            }
        }
        return max;
    }
}
