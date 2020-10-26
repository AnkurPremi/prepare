package DataStructures.NewWork.LCArray;

public class CheckIfStraightLine {
    public static void main(String[] args) {
        int[][] g = {{1,-8},{2,-3},{1,2}};
        System.out.println(new CheckIfStraightLine().checkStraightLine(g));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int slopeX = -1;
        int slopeY = -1;
        for(int i=1; i<coordinates.length ; i++){
            int x = Math.abs(coordinates[i-1][0] - coordinates[i][0]);
            int y = Math.abs(coordinates[i-1][1] - coordinates[i][1]);
            if(slopeX == -1){
                slopeX = x;
                slopeY = y;
            } else if(slopeX*y != slopeY*x){
                return false;
            }
        }
        return true;
    }
}
