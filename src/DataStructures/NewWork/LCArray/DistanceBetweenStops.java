package DataStructures.NewWork.LCArray;

public class DistanceBetweenStops {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(new DistanceBetweenStops().distanceBetweenBusStops(arr, 0, 3));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int d1 = 0;
        int d2 = 0;
        int n = distance.length;
        int i = start;
        while(true){
            d1 += distance[i];
            i = (i+1)%n;
            if(i == destination) break;
        }

        i = destination;
        while(true){
            d2 += distance[i];
            i = (i+1)%n;
            if(i == start) break;
        }

        if (d1 == 0)
            return d2;
        if (d2 == 0)
            return d1;

        return d1 < d2 ? d1 : d2;
    }
}
