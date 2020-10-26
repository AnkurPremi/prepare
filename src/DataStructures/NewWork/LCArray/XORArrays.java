package DataStructures.NewWork.LCArray;

public class XORArrays {
    public static void main(String[] args) {
        System.out.println(new XORArrays().xorOperation(5, 3));
    }

    public int xorOperation(int n, int start) {
        int prev = 0;
        int j = 0;
        while(j < n){
            prev = prev ^ (start + 2*j);
            j++;
        }
        return prev;
    }
}
