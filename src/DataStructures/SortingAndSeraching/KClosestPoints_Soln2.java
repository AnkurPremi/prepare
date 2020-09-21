package DataStructures.SortingAndSeraching;

//We will first find out which elements can be rejected by using qSort technique
//
public class KClosestPoints_Soln2 {
    public static void main(String[] args) {

    }
    public static int[][] kClosest(int[][] points, int K) {
        return points;
    }

    public static int partition(int[][] points, int start, int end){
        int[] pivot = points[end];
        int pIndex = start;
        for(int i=start ;i< end; i++){
            if(comparePoints(points[i], pivot)){

            }
        }
        return pIndex;
    }

    static boolean comparePoints(int[] p, int[] q){
        return false;
    }
}
