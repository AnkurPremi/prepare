package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity2 {
    public static void main(String[] args) {
        int[] arr = {648, 831, 560, 986, 192, 424, 997, 829, 897, 843};
//        System.out.println(new SortArrayByParity2().fib1(10));
        new SortArrayByParity2().sortArrayByParityII(arr);
    }

    public int fib1(int n){
        int f1 = 0, f2 = 1;
        for(int i=2 ; i<=n ; i++){
            int temp = f2;
            f2 = f2 + f1;
            f1 = temp;
        }
        return f2;
    }

    public int[] sortArrayByParityII(int[] A) {
        int r = 0, j = 0;
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        while (r < A.length) {
            //odd element at even location
            if (A[r] % 2 != 0 && j % 2 == 0) {
                if (even.size() > 0) {
                    int idx = even.get(even.size() - 1);
                    int temp = A[idx];
                    A[idx] = A[r];
                    A[r] = temp;
                    even.remove(even.size() - 1);
                } else {
                    odd.add(r);
                }
            }
            //even element at odd
            else if (A[r] % 2 == 0 && j % 2 != 0) {
                if (odd.size() > 0) {
                    int idx = odd.get(odd.size() - 1);
                    int temp = A[idx];
                    A[idx] = A[r];
                    A[r] = temp;
                    odd.remove(odd.size() - 1);
                } else {
                    even.add(r);
                }
            }
            r++;
            j++;
        }
        return A;
    }
}
