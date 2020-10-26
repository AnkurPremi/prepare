package DataStructures.BinarySearch;

import java.util.TreeMap;

public class BloomFlowers {
    public static void main(String[] args) {
        int[] bd = {1000000000, 1000000000};
        TreeMap<Integer,int[]> map = new TreeMap<>();
        System.out.println(new BloomFlowers().minDays(bd, 1,1));
    }

    public int minDays(int[] bd, int m, int k) {
        if(m*k > bd.length) return -1;
        int l = 1, r = 1000000000;
        int ans = -1;
        while(l <= r){
            int day = (l+r) >> 1;
            boolean possible = canMake(bd, day, m, k);
            if(possible){
                ans = day;
                r = day - 1;
            } else{
                l = day + 1;
            }
        }
        return ans;
    }

    public boolean canMake(int[] bd, int day, int m, int k){
        int n = k;
        for(int i : bd){
            if(i <= day)
                n--;
            else
                n = k;

            if(n == 0) {
                m--;
                if(m == 0) return true;
                n = k;
            }
        }
        return m == 0;
    }
}
