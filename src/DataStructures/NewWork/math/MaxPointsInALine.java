package DataStructures.NewWork.math;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsInALine {
    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(new MaxPointsInALine().maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n < 3) return n;

        Map<String, Integer> map = new HashMap();
        int ans = 0;
        StringBuilder builder = new StringBuilder();

        for(int i = 0 ; i < n ; i++){

            int count = 0;
            int duplicate = 0; //we can have same point multiple times

            for(int j = i + 1 ; j < n ; j++){

                int slopeX = points[j][0] - points[i][0];
                int slopeY = points[j][1] - points[i][1];

                if(slopeX == 0 && slopeY == 0){
                    duplicate++;
                    continue;
                }

                int gcd = findGCD(slopeX, slopeY);

                slopeX = slopeX / gcd;
                slopeY = slopeY / gcd;

                String s = builder.append(slopeY).append(',').append(slopeX).toString();
                int val = map.getOrDefault(s, 0) + 1;
                map.put(s, val);

                count = Math.max(val, count);
                builder.setLength(0);
            }
            map.clear();
            ans = Math.max(ans, count + 1 + duplicate);
        }

        return ans;
    }

    private int findGCD(int a, int b){
        if(b == 0) return a;
        return findGCD(b, a % b);
    }
}
