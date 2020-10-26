package DataStructures.NewWork.LCArray;

public class ShipWithinDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(new ShipWithinDays().shipWithinDays(weights, D));
    }

    public int shipWithinDays(int[] weights, int D) {
        int totalWeight = 0;
        for(int i=1; i<weights.length ; i++){
            weights[i] = weights[i] + weights[i-1];
        }
        totalWeight = weights[weights.length-1];

        int start = 1, end = totalWeight;
        while(start <= end){
            int m = (start+end) >> 1;
            int v = doBinarySearch(weights, m, D);
            if(v > D)
                start = m + 1;
            else
                end = m - 1;
        }

        return start;
    }

    public int doBinarySearch(int[] weights, int num, int D){
        int l = 0, r = weights.length-1;
        int ans = 1;
        int w = num;
        while(true) {
            while (l < r) {
                int m = (l + r) >> 1;
                if (weights[m] <= w) {
                    ans = weights[m];
                    l = m + 1;
                } else
                    r = m - 1;
            }
            r = weights.length-1;
            w = ans + num;
            D--;
            if(D <= 0) return D;
            if(w >= weights[weights.length-1])
                break;
        }
        return D;
    }
}
