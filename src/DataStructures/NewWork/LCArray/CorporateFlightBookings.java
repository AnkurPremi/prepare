package DataStructures.NewWork.LCArray;

public class CorporateFlightBookings {
    public static void main(String[] args) {
     int[][] arr = {{1,2,10},{2,3,20},{2,5,25}};
     new CorporateFlightBookings().corpFlightBookings1(arr, 5);
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] v : bookings) {
            res[v[0] - 1] += v[2];
            if (v[1] < n) res[v[1]] -= v[2];
        }
        for (int i = 1; i < n; ++i) res[i] += res[i - 1];
        return res;
    }

    public int[] corpFlightBookings1(int[][] bookings, int n) {
        //inclusive
        int ans[]=new int[n];int startarr[]=new int[n];
        int endarr[]=new int[n];
        for(int i=0;i<bookings.length;i++){
            int start=bookings[i][0]-1;int end=bookings[i][1]-1;
            int cost=bookings[i][2];
            startarr[start]+=cost;endarr[end]+=cost;
        }
        int sum=0;
        for(int i=0;i<ans.length;i++){
            sum+=startarr[i]; //0 has no effect
            ans[i]=sum;
            sum-=endarr[i];
        }
        return ans;
    }
}
