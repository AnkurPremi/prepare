package DataStructures.NewWork.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOrder {
    public static void main(String[] args) {
//        System.out.println(new CountOrder().countOrders(3));
        new CountOrder().lis("badbc");
    }

    private int lis(String s){
        int n = s.length(), m = 10;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;

        for(int i= 0 ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                for(int k = 0 ; k<m ; k++) {
                    if (s.charAt(i) > s.charAt(j)) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = 1 + dp[j];
                        }
                    }
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public int countOrders(int n) {
        List<String> pickup = new ArrayList<>();
        List<String> delivery = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            String p = "P" + i;
            String d = "D" + i;
            pickup.add(p);
            delivery.add(d);
        }
        List<List<String>> res = new ArrayList<>();
        getCombos(pickup, delivery, res, new ArrayList<>(), new boolean[n], new boolean[n]);
        System.out.println(res);
        return res.size();
    }

    public void getCombos (List<String> pickup, List<String> delivery, List<List<String>> res, List<String> curr, boolean[] picked, boolean[] delivered) {
        if (curr.size() == pickup.size() * 2)
            res.add(new ArrayList<>(curr));

        for (int i=0; i<pickup.size(); i++) {
            if (!picked[i]) {
                curr.add(pickup.get(i));
                picked[i] = true;
                getCombos(pickup, delivery, res, curr, picked, delivered);
                curr.remove(curr.size()-1);
                picked[i] = false;
            }
        }
        for (int i=0; i<delivery.size(); i++) {
            if (picked[i] && !delivered[i]) {
                curr.add(delivery.get(i));
                delivered[i] = true;
                getCombos(pickup, delivery, res, curr, picked, delivered);
                curr.remove(curr.size()-1);
                delivered[i] = false;
            }
        }
    }
}
