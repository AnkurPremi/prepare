package DataStructures.Hackerrank.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClimbingTheLeadership {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(100, 100, 50, 40, 40, 20, 10));
        List<Integer> scores = new ArrayList<>(Arrays.asList(5, 25, 50, 120));
        ClimbingTheLeadership.climbingLeaderboard(list, scores);
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> ranks = new ArrayList();
        int rank = 1;
        ranks.add(1);
        for (int i = 1; i < ranked.size(); i++) {
            if (ranked.get(i - 1) == ranked.get(i)) {
                ranks.add(rank);
            } else {
                ranks.add(++rank);
            }
        }
        List<Integer> results = new ArrayList();
        for (int i = 0; i < player.size(); i++) {
            int idx = search(ranked, player.get(i));
            if (idx == -1) {
                results.add(rank + 1);
            } else {
                results.add(ranks.get(idx));
            }
        }
        return results;
    }

    private static int search(List<Integer> rankedScores, int score) {
        int n = rankedScores.size();
        if (score > rankedScores.get(0)) return 0;
        else if (score < rankedScores.get(n - 1)) return -1;
        else {

            int start = 0, end = n - 1;
            while (start <= end) {
                int mid = (start + end) >> 1;
                if (rankedScores.get(mid) == score) {
                    return mid;
                } else if (score > rankedScores.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }
    }
}
