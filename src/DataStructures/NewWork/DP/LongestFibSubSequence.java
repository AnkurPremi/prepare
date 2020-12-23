package DataStructures.NewWork.DP;

import DataStructures.NewWork.LCArray.LongestFibSeqLen;
import DataStructures.NewWork.LCStrings.LongestCommonPrefix;

import java.util.HashMap;
import java.util.Map;

public class LongestFibSubSequence {
    public static void main(String[] args) {
        int[] seq = {2,4,7,8,9,10,14,15,18,23,32,50};
        System.out.println(new LongestFibSubSequence().lenLongestFibSubseq(seq));
    }

    public int lenLongestFibSubseq(int[] A) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++)
            map.put(A[i], i);

        for (int i = 0; i < A.length - 2; i++) {
            int j = i, k = i + 1;

            //early break
            if(A.length-k < ans)
                break;

            int len = 2;
            while(k < A.length){
                int sum = A[j] + A[k];
                if(map.containsKey(sum)){
                    len++;
                    j = k;
                    k = map.get(sum);
                    ans = Math.max(len, ans);
                } else{
                    k++;
                }
            }
        }

        return ans;
    }
}
