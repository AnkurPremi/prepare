package DataStructures.BitManipulation;

public class HammingDistance {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 15;
        int n3 = n1^n2;
        int count = 0;
        while(n3 > 0){
            count++;
            n3 = n3 & (n3-1);
        }
        System.out.println(count);
    }
}
