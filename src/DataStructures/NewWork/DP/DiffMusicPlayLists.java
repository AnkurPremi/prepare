package DataStructures.NewWork.DP;

import java.util.ArrayList;
import java.util.List;

public class DiffMusicPlayLists {
    public static void main(String[] args) {
        int N = 2, L = 3, K = 0;
        System.out.println(new DiffMusicPlayLists().numMusicPlaylists(N, L, K));
    }

    List<Integer>[] map;
    public int numMusicPlaylists(int N, int L, int K) {
        map = new List[N];
        for(int i = 0 ; i < N ; i++) map[i] = new ArrayList();
        return countDiff(N, L, K, 0);
    }

    private int countDiff(int n, int l, int k, int count){
        if(count == l) {
            for(List<Integer> list : map) if(list.isEmpty()) return 0;
            return 1;
        }

        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            if(map[i].isEmpty() || count - map[i].get(map[i].size() - 1) > k){
                map[i].add(count);
                ans += countDiff(n, l, k, count + 1);
                map[i].remove(map[i].size() - 1);
            }
        }
        return ans;
    }
}
