package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.Arrays;

public class CountSquarefulPermutations {
    public static void main(String[] args) {
        int[] A = {1, 17, 8};
        System.out.println(new CountSquarefulPermutations().numSquarefulPerms(A));
    }

//    private int ans = 0;
//    private void helper(int count, int[] A, boolean[] used, int lastNumber){
//        if (count ==A.length){
//            ans++;
//        } else {
//            for (int i = 0; i<A.length;i++){
//                if (used[i] || (i>0 && A[i]==A[i-1] && !used[i-1]))continue;
//                if (lastNumber!=-1){
//                    // if we cant form a square we can not proceed to form a squareful array
//                    if (isPerfectSquare(A[i],lastNumber)==false)
//                        continue;
//                }
//                used[i] = true;
//                helper(count + 1,A,used,A[i]);
//                used[i] = false;
//            }
//        }
//
//    }
//    public int numSquarefulPerms(int[] A) {
//        Arrays.sort(A);
//        helper(0,A,new boolean[A.length],-1);
//        return ans;
//    }

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        return helper(A, -1, -1, 0, new boolean[A.length]);
    }

    private int helper(int[] A, int prevIdx, int seenIdx, int count, boolean[] visited) {
        if (count == A.length) return 1;

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            if (visited[i] || (i > 0 && A[i] == A[i-1] && !visited[i-1])) continue;

            if (prevIdx != -1 && !isPerfectSquare(A[prevIdx], A[i])) {
                continue;
            }
            visited[i] = true;
            ans += helper(A, i, -1, count + 1, visited);
            visited[i] = false;

        }
        return ans;
    }

    private boolean isPerfectSquare(int v1, int v2) {
        double sqrt = Math.sqrt(v1 + v2);
        if (sqrt - Math.floor(sqrt) == 0) {
            return true;
        }
        return false;
    }
}
