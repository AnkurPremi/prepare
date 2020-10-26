package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class ArrayDisjointIntervals {
    public static void main(String[] args) {
        int[] arr = {5,0,3,8,6};
        System.out.println(new ArrayDisjointIntervals().partitionDisjoint(arr));
    }

    public int partitionDisjoint(int[] A) {
        int[] biggestFromLeft = new int[A.length];
        int[] smallestFromLeft = new int[A.length];

        biggestFromLeft[0] = A[0];
        smallestFromLeft[A.length-1] = A[A.length-1];
        for(int i=1, j=A.length-2 ; i<A.length && j>=0 ; i++, j--){
            biggestFromLeft[i] = Math.max(A[i], biggestFromLeft[i-1]);
            smallestFromLeft[j] = Math.min(A[j], smallestFromLeft[j+1]);
//            System.out.println("biggest from left: "+ Arrays.toString(biggestFromLeft));
//            System.out.println("smallest from right: "+Arrays.toString(smallestFromLeft));
        }

        for(int i=0 ; i<A.length-1 ; i++){
//            System.out.println("biggest from left: "+biggestFromLeft[i]);
//            System.out.println("smallest from right: "+smallestFromLeft[i]);
            if(biggestFromLeft[i] < smallestFromLeft[i+1]) return i+1;
        }

        return A.length-2;
    }
}
