package DataStructures.strings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/stamping-the-sequence/
//https://leetcode.com/problems/stamping-the-sequence/discuss/201546/12ms-Java-Solution-Beats-100
public class StampingTheSequence {
    public static void main(String[] args) {
        String stamp = "abc";
        String target = "ababcaaabc";
        int[] result = new StampingTheSequence().movesToStamp(stamp, target);
        System.out.println(":casc");
    }

    public int[] movesToStamp(String stamp, String target) {
        if (stamp.equals(target)) return new int[]{0};
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();
        List<Integer> result = new ArrayList<>();
        //this array will be used to not again traverse the same index where a * replacement is already done
        //or the index where stamping was done
        boolean[] visited = new boolean[target.length()];
        int stars = 0;
        while (stars < target.length()) {
            //this boolean will help to check if in one iteration the loop was not able to add any stars
            //then stamping the target is not possible
            boolean isFoundAndReplaced = false;
            //in first iteration we will search for stamp 'abc' and replace it with *
            //in subsequent iteration, we will search for *bc, bc*, a*  ... as per the conditions
            for (int i = 0; i < target.length() - stamp.length()+1; i++) {
                if (!visited[i] && canReplace(T, S, i)) {
                    stars += replace(T, i, S.length);
                    visited[i] = true;
                    isFoundAndReplaced = true;
                    result.add(i);
                    //if all the chars in target are replaced with *, break the for loop
                    if (stars == T.length) {
                        break;
                    }
                }
            }
            if (!isFoundAndReplaced) {
                return new int[0];
            }
        }

        int[] finalR = new int[result.size()];
        for (int i = 0, j=result.size()-1; j>=0 && i < result.size(); i++, j--) {
            finalR[i] = result.get(j);
        }
        return finalR;
    }

    //this method will be used to compare the stamp chars and remaining target chars
    //if it's possible to replace the chars with stars
    //or if the stamping was done at pth position
    public boolean canReplace(char[] T, char[] S, int p) {
        for (int i = 0; i < S.length; i++) {
            //if the char is not * , then it should match with the stamp chars
            if (T[p + i] != '*' && T[p + i] != S[i]) {
                return false;
            }
        }
        //found abc, *bc, bc*, a** ....
        return true;
    }

    //this method will be used for replacing the pattern found in 'canReplace' method
    //with stars and counting the numbe of stars added
    public int replace(char[] T, int pos, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (T[i + pos] != '*') {
                T[i + pos] = '*';
                count++;
            }
        }
        return count;
    }
}
