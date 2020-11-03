package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StampingTheSequence2 {
    public static void main(String[] args) {
        String stamp = "abca";
        String seq = "aabcaca";
        int[] ans = new StampingTheSequence2().stampSeq(stamp, seq);
        System.out.println(Arrays.toString(ans));
        System.out.println("asdasd");
    }

    public int[] stampSeq(String stamp, String seq) {
        if (stamp.equals(seq)) return new int[0];
        //we will do reverse engineering
        //search for possible stamps and remove them
        int stars = 0;
        char[] s = stamp.toCharArray();
        char[] t = seq.toCharArray();
        boolean[] seen = new boolean[t.length];
        List<Integer> stamps = new ArrayList<>();
        while (stars < t.length) {

            boolean found = false;
            for (int i = 0; i < t.length - s.length + 1; i++) {
                if(seen[i] || !canReplace(s, t, i))
                    continue;
                stars += replace(t, i, s.length);

                found = true;
                stamps.add(i);
                seen[i] = true;

                if(stars == t.length)
                    break;
            }
            if(!found) return new int[0];
        }

        int[] ans = new int[stamps.size()];
        int writer = ans.length-1;
        for(int i : stamps){
            ans[writer--] = i;
        }
        return ans;
    }

    private boolean canReplace(char[] s, char[] t, int idx){
        for(int i=0 ; i<s.length ; i++){
            if(t[idx+i] != '*' && t[idx+i] != s[i])
                return false;
        }
        return true;
    }

    private int replace(char[] t, int idx, int size){
        int count = 0;
        for(int i=0 ; i<size ; i++){
            if(t[idx+i] != '*'){
                t[idx+i] = '*';
                count++;
            }
        }
        return count;
    }
}
