package problemsArray;

//https://leetcode.com/problems/maximize-distance-to-closest-person/
public class MaximizeDistancetoClosestPerson {
    public static void main(String[] args) {
        int[] seats = {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0};
        new MaximizeDistancetoClosestPerson().maxDistToClosest(seats);
    }

    public int maxDistToClosest(int[] seats) {
        int start = -1;
        int end = 0;
        int max = 0;
        for(int i=0; i < seats.length ; i++){
            if(seats[i] == 1){
                if(start == -1){
                    max = Math.max(end, max);
                }else{
                    max = Math.max((end-start)>>1, max);
                }
                start = end = i;
            }
            end++;
        }
        //there are 0's at the end
        if(start != end){
            max = Math.max(max, end-start);
        }
        return max;
    }
}
