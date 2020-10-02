package DataStructures.problemsArray;

import java.util.Arrays;

public class CarPooling {
    public static void main(String[] args) {
        int[][] trips = {
                {3, 2, 7},
                {3, 7, 9},
                {8, 3, 9}
        };
        new CarPooling().carPooling(trips, 11);
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int stops[] = new int[10];
        for (int t[] : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for (int i = 0; capacity >= 0 && i < 10; ++i) {
            capacity -= stops[i];
        }
        return capacity >= 0;
    }
}
