package DataStructures.NewWork.Backtrack;

import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancing {
    public static void main(String[] args) {
        int[][] txn = {{1, 2, 3}, {2, 3, 5}, {4, 1, 6}};
        System.out.println(new OptimalAccountBalancing().minTransfers(txn));
    }


    public int minTransfers(int[][] transactions) {
        int[] debt = createDbtArray(transactions);
        return minTxn(debt, 0);
    }

    private int minTxn(int[] debt, int idx) {
        int n = debt.length;

        while (idx < n && debt[idx] == 0) idx++;

        if (idx == n) return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = idx + 1; i < n; i++) {
            //if any of them borrowed money..let's settle debt b/w them
            if (debt[i] * debt[idx] < 0) {
                debt[i] += debt[idx]; //settle the debt
                ans = Math.min(ans, 1 + minTxn(debt, idx + 1));
                debt[i] -= debt[idx]; //already checked this combination..bring it back to the same position

//                ultimate pruning or debt[i] = -debt[idx] //same amount one +ve one -ve
                if(debt[i] + debt[idx] == 0){
                    break;
                }
            }
        }

        return ans;
    }

    private int[] createDbtArray(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap();

        for (int[] txn : transactions) {
            map.put(txn[0], map.getOrDefault(txn[0], 0) + txn[2]);
            map.put(txn[1], map.getOrDefault(txn[1], 0) - txn[2]);
        }

        int[] debt = new int[map.size()];
        int i = 0;
        for (int amount : map.values()) {
            debt[i++] = amount;
        }

        return debt;
    }

}
