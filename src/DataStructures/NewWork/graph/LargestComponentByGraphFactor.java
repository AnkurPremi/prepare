package DataStructures.NewWork.graph;

import java.util.*;

public class LargestComponentByGraphFactor {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7,4,12,21,39};
        System.out.println(new LargestComponentByGraphFactor().largestComponentSize(arr));
    }

    public int largestComponentSize(int[] A) {
        int[] visited = new int[A.length];
        int[] links = new int[A.length];
        for(int i = 0 ; i  < A.length ; i++){
            links[i] = i;
        }
        for(int i = 0 ; i < A.length - 1 ; i++){
            for(int j = i + 1 ; j < A.length ; j++){
//                if(visited[j] != 0) continue;
                if(gcd(A[i], A[j]) > 1){
                    links[j] = i;
//                    visited[j] = 1;
                }
            }
        }

        Arrays.fill(visited, 0);
        int max = 0;
        for(int i = 0 ; i < A.length ; i++){
            int parent = findParent(links, i);
            visited[parent]++;
            max = Math.max(visited[parent], max);
        }

        return max;
    }

    private int findParent(int[] nums, int i){
        while(i != nums[i]){
            i = nums[i];
        }
        return i;
    }


    private int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
