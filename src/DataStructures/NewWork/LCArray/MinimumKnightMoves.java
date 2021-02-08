package DataStructures.NewWork.LCArray;

import java.util.*;

public class MinimumKnightMoves {
    public static void main(String[] args) {
        System.out.println(new MinimumKnightMoves().minKnightMoves(2, 112));
    }

    public int minKnightMoves1(int x, int y) {
        int MOD = Math.abs(y) + 2;
        return dfs(Math.abs(x), Math.abs(y), new HashMap<>(), MOD);
    }

    public int dfs(int x, int y, Map<Integer, Integer> map, int MOD) {
        int index = x * MOD + y;
        if (map.containsKey(index)) {
            return map.get(index);
        }
        int ans = 0;
        //since we are considering +ve values of x and y.. x + y == 0 is same as x == 0 && y == 0
        if (x + y == 0) {
            ans = 0;
        }
        else if (x + y == 2) {
            ans = 2;
        }
        else {
            ans = Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2), map, MOD),
                    dfs(Math.abs(x - 2), Math.abs(y - 1), map, MOD)) + 1;
        }
        map.put(index, ans);
        return ans;
    }


    public int minKnightMoves(int x, int y) {
        int[][] moves = {{2, -1}, {2, 1}, {-2, -1}, {-2, 1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
        Queue<int[]> queue = new LinkedList<>();
        int steps = 0;
        queue.offer(new int[]{0, 0});
//        boolean[][] visited = new boolean[300][300];
        Set<Integer> visited = new HashSet<>();
        x = Math.abs(x);
        y = Math.abs(y);
        int mult = 1000;
        visited.add(x * mult + y);
        while(!queue.isEmpty()){
            steps++;
            int size = queue.size();
            for(int i=0 ; i<size ; i++){
                int[] node = queue.poll();

                for(int[] move : moves){
                    int newX = node[0] + move[0];
                    int newY = node[1] + move[1];
                    if(newX == x && newY == y) return steps;
                    if(!visited.contains(mult * newX + newY) && newX >= -1 && newX >= -1) {
                        queue.offer(new int[]{newX, newY});
                        visited.add(mult * newX + newY);
                    }
                }
            }
        }
        return steps - 1;
    }

//
//    public int minKnightMoves(int x, int y) {
//        int[][] moves = {{2, -1}, {2, 1}, {-2, -1}, {-2, 1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
//        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
//        return minMoves(0, 0, moves, map, x, y);
//    }
//
//    private int minMoves(int r, int c, int[][] moves, Map<Integer, Map<Integer, Integer>> map, int x, int y) {
//        if (r == x && c == y) return 0;
//        if (Math.abs(r) + Math.abs(c) > 300) return -1;
//
//        if(map.containsKey(r) && map.get(r).containsKey(c)) return map.get(r).get(c);
//
//        int min = Integer.MAX_VALUE;
//
//        for (int[] move : moves) {
//            int count = minMoves(r + move[0], c + move[1], moves, map, x, y);
//            if (count > -1 && count < Integer.MAX_VALUE) {
//                min = Math.min(min, 1 + count);
//            }
//        }
//
//        if(!map.containsKey(r)){
//            map.put(r, new HashMap<>());
//        }
//        map.get(r).put(r, min);
//
//        return min;
//    }
}
