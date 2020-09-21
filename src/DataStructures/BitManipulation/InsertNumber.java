package DataStructures.BitManipulation;

//Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and
//j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
//can assume that the bits j through i have enough space to fit all of M. That is, if
//M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
//example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
//EXAMPLE
//Input:
//N
//10000000000, M
//Output: N = 10001001100
public class InsertNumber {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("10000000000", 2));
        System.out.println(Integer.parseInt("10011", 2));
        System.out.println(Integer.toBinaryString(insertNumber(1024, 19, 6, 2)));

        System.out.println(Integer.parseInt("10001000100", 2));
        System.out.println(Integer.parseInt("10010", 2));
        System.out.println(Integer.toBinaryString(insertNumber(1092, 18, 6, 2)));
    }

    public static int insertNumber(int n, int m, int i, int j) {
        int k = j;
        String s = Integer.toBinaryString(m);
        int p = s.length() - 1;
        while (k >= j && k <= i) {
            if (s.charAt(p) == '1') {
                System.out.println("Before - " + Integer.toBinaryString(n));
                n = n | (1 << k);//set the bit
                System.out.println("After - " + Integer.toBinaryString(n));
            } else {
                System.out.println("Before - " + Integer.toBinaryString(n));
                n = n & ~(1 << k);//clear the bit
                System.out.println("After - " + Integer.toBinaryString(n));
            }
            k++;
            p--;
        }
        return n;
    }
}
