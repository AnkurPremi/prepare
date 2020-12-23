package DataStructures.NewWork.DP;

public class CountAllValidPickupAndDelivery {
    public static void main(String[] args) {
        System.out.println(new CountAllValidPickupAndDelivery().countOrders(3));
    }

    public int countOrders(int n) {
        return helper(n, n);
    }

    private int helper(int p, int d){
        if(d < p) return 0;
        if(p < 0 || d < 0) return 0;
        System.out.println("p=" + p + "  d="+d);
        if(p == 0 && d == 0) return 1;
        int val = 0;
        if( p > 0)
            val += helper(p-1, d);
        val += helper(p > 0 ? p-1 : 0, d-1);
        val += helper(p, d-1);

        return val;
    }
}
