package DataStructures.BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {
    public static void main(String[] args) {
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        TopVotedCandidateHelper th = new TopVotedCandidateHelper(persons, times);
        System.out.println(th.q(3));
        System.out.println(th.q(12));
        System.out.println(th.q(25));
        System.out.println(th.q(15));
        System.out.println(th.q(24));
        System.out.println(th.q(8));
    }
}

class TopVotedCandidateHelper {

    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Integer> timeVsWinner = new HashMap<>();
    int[] times;

    public TopVotedCandidateHelper(int[] persons, int[] times) {
        this.times = times;
        int max = -1;
        int winner = -1;
        for (int i = 0; i < times.length; i++) {
            int count = freq.getOrDefault(persons[i], 0) + 1;
            freq.put(persons[i], count);
            if (count >= max) {
                max = count;
                winner = persons[i];
            }
            timeVsWinner.put(times[i], winner);
        }
    }

    public int q(int t) {
        int l = 0, r = times.length - 1;
        int time = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (times[m] <= t) {
                time = times[m];
                l = m + 1;
            } else
                r = m - 1;
        }
        return timeVsWinner.get(time);
    }
}
