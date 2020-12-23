package DataStructures.NewWork.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MusicPlayList {
    public static void main(String[] args) {
        System.out.println(new MusicPlayList().numMusicPlaylists(2, 3, 0));
    }
    public int numMusicPlaylists(int N, int L, int K) {
        int[] lastPlayed = new int[N+1];
        Arrays.fill(lastPlayed, -102);
        int[] val = {0};
        helper(N, L, K, lastPlayed, 0, val);
        return val[0];
    }

    Set<Integer> set = new HashSet<>();
    private void helper(int N, int L, int K, int[] lastPlayed, int count, int[] val){
        if(count == L){
            if(set.size() == N)val[0] += 1;
            return;
        }

        for(int i=1 ; i<=N ; i++){
//            System.out.println("count-"+count);
            if(count-lastPlayed[i] > K) {
//                System.out.println("song-" + i);
                boolean add = false;
                if(!set.add(i)){
                    if(set.size() < N) continue;
                }
                add = true;
                int prev = lastPlayed[i];
                lastPlayed[i] = count;
                helper(N, L, K, lastPlayed, count + 1, val);
                lastPlayed[i] = prev;
                if(add)
                    set.remove(i);
            }
        }
        return;
    }
}
