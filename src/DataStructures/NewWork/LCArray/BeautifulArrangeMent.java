package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.Map;

public class BeautifulArrangeMent {
    public static void main(String[] args) {

    }

    Map<Integer, Integer> map = new HashMap();
    public int countArrangement(int n) {
        return helper(n, 1, 0);
    }

    private int helper(int n, int count, int num){
        if(count > n) return 1;
        if(map.containsKey(num)) return map.get(num);
        int ans = 0;

        for(int i=1 ; i<=n ; i++){
            if(((num & (1 << i)) == 0) && (i % count == 0 || count % i == 0)){
                num |= 1 << i;
                ans += helper(n, count + 1, num);
                num &= ~(1 << i);
            }
        }
        map.put(num, ans);
        return ans;
    }
}
