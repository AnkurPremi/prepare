package DataStructures.BinarySearch;

import java.util.Arrays;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] arr = {312884470};
        System.out.println(new KokoEatingBanana().minEatingSpeed(arr, 312884469));
    }

    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        int l = 1, r = piles[piles.length - 1];
        int ans = r;
        while (l <= r) {
            int m = (l + r) >> 1;
            int idx = doBinarySearch(piles, m);
            boolean canComplete = walk(piles, idx + 1, H - idx - 1, m);
            if (canComplete) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public boolean walk(int[] piles, int idx, int h, int m) {
        for (int i = idx; i < piles.length; i++) {
            h = h - piles[i] / m;
            if (piles[i] % m != 0) {
                h--;
            }
        }
        return !(h < 0);
    }

    public int doBinarySearch(int[] piles, int val) {
        int l = 0, r = piles.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (piles[m] <= val) {
                ans = m;
                l = m + 1;
            } else r = m - 1;
        }
        return ans;
    }
}
