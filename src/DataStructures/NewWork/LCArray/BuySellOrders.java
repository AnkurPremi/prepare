package DataStructures.NewWork.LCArray;

import java.util.Map;
import java.util.TreeMap;

public class BuySellOrders {
    public static void main(String[] args) {
        int[][] orders = {{1,29,1},{22,7,1},{24,1,0},{25,15,1},{18,8,1},{8,22,0},{25,15,1},{30,1,1},{27,30,0}};
        System.out.println(new BuySellOrders().getNumberOfBacklogOrders(orders));
    }

    long mod = (long) 1e9 + 7;

    public int getNumberOfBacklogOrders(int[][] orders) {
        TreeMap<Integer, Integer> buyOrder = new TreeMap<>();
        TreeMap<Integer, Integer> sellOrder = new TreeMap<>();
        long ans = 0;
        for (int[] order : orders) {
            if (order[2] == 0) {
                int buyQty = order[1], buyPrice = order[0];
                while (buyQty != 0) {
                    Map.Entry<Integer, Integer> availableSellEntry = sellOrder.floorEntry(buyPrice);
                    if (availableSellEntry == null) {
                        buyOrder.put(buyPrice, buyOrder.getOrDefault(buyPrice, 0) + buyQty);
                        buyQty = 0;
                    } else if (availableSellEntry.getValue() <= buyQty) {
                        buyQty -= availableSellEntry.getValue();
                        sellOrder.remove(availableSellEntry.getKey());
                    } else {
                        sellOrder.put(availableSellEntry.getKey(), availableSellEntry.getValue() - buyQty);
                        buyQty = 0;
                    }
                }
            } else {
                int sellQty = order[1], sellPrice = order[0];

                while (sellQty != 0) {
                    Map.Entry<Integer, Integer> availableBuyEntry = buyOrder.ceilingEntry(sellPrice);
                    if (availableBuyEntry == null) {
                        sellOrder.put(sellPrice, sellOrder.getOrDefault(sellPrice, 0) + sellQty);
                        sellQty = 0;
                    } else if (availableBuyEntry.getValue() <= sellQty) {
                        sellQty -= availableBuyEntry.getValue();
                        buyOrder.remove(availableBuyEntry.getKey());
                    } else {
                        buyOrder.put(availableBuyEntry.getKey(), availableBuyEntry.getValue() - sellQty);
                        sellQty = 0;
                    }
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : sellOrder.entrySet()) {
            ans += entry.getValue();
        }

        for (Map.Entry<Integer, Integer> entry : buyOrder.entrySet()) {
            ans += entry.getValue();
        }

        return (int) (ans % mod);
    }
}
