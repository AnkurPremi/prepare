package DataStructures.NewWork.Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPickwithBlacklist {
    public static void main(String[] args) {
        int[] arr = {0,1};
        Solution solution = new Solution(4, arr);
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
    }


}

class Solution {

    List<Pair> list = null;

    public Solution(int N, int[] blacklist) {
        this.list = new ArrayList();
        createInterval(blacklist, N);
    }

    private void createInterval(int[] bl, int N) {
        int start = 0;
        if (bl.length == 0) {
            list.add(new Pair(0, N));
            return;
        }
        for(int i=0 ; i<bl.length ; i++){
            if(bl[i] - start > 0){
                list.add(new Pair(start, bl[i]));
            }
            start = bl[i]+1;
        }
        if (start < N) {
            list.add(new Pair(start, N));
        }
    }

    public int pick() {
        int location = ThreadLocalRandom.current().nextInt(0, list.size());
        Pair p = list.get(location);
        int ans = ThreadLocalRandom.current().nextInt(p.start, p.end);
        return ans;
    }

    class Pair {
        int start, end;

        Pair(int s, int e) {
            start = s;
            end = e;
        }
    }
}