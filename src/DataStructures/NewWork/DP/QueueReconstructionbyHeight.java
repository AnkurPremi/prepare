package DataStructures.NewWork.DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionbyHeight {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(new QueueReconstructionbyHeight().reconstructQueue(people));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (n1, n2) -> (n2[0] == n1[0]) ? n1[1] - n2[1] : n2[0] - n1[0]);
        List<int[]> res = new LinkedList<>();
        for (int[] p : people) res.add(p[1], p);
        return res.toArray(new int[people.length][2]);
    }
}
