package DataStructures.problemsArray;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new GasStation().canCompleteCircuit(gas,cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int maxIdx = -1;
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (gas[i] - cost[i] > 0) {
                if (gas[i] - cost[i] > maxVal) {
                    maxVal = gas[i] - cost[i];
                    maxIdx = i;
                }
            }
        }
        return sum >= 0 ? maxIdx : -1;
    }
}
