package DataStructures.NewWork.LCArray;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxFlipsToConvertBinaryArrayToZero_Hard {
    public static void main(String[] args) {
        int[][] mat = {{0, 0}, {0, 1}};
        System.out.println(new MaxFlipsToConvertBinaryArrayToZero_Hard().minFlips(mat));
    }


    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minFlips(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int startNode = convert(mat);
        if (startNode == 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        Set<Integer> set = new HashSet();
        set.add(startNode);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            while (size > 0) {
                size--;

                int cur = queue.poll();
                if (cur == 0) return steps + 1;

                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {

                        int next = cur;

                        for (int[] dir : directions) {
                            int x = i + dir[0];
                            int y = j + dir[1];

                            if (x < 0 || y < 0 || x >= m || y >= n) continue;

                            next ^= 1 << (x * n + y);

                        }

                        if (set.add(next)) {
                            queue.offer(next);
                        }

                    }
                }

            }
        }

        return -1;

    }

    private int convert(int[][] mat) {
        int num = 0, n = mat.length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    num |= 1 << (i * n + j);
            }
        }
        return num;
    }
}
