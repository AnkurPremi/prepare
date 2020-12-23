package DataStructures.NewWork.BitManipulation;

public class HammingDistance {
    public static void main(String[] args) {
        int n = 3 ^ 1;
        System.out.println(new HammingDistance().hammingDistance(4,12));
    }

    public int hammingDistance(int x, int y) {
        x = x ^ y;
        int count = 0;
        while(x > 0){
            count++;
            x &= (x-1);
        }
        return count;
    }
}
