package DataStructures.codechef;

//https://www.codechef.com/LRNDSA01/problems/MULTHREE
public class MultipleOf3 {

    public static void main(String[] args) {
        System.out.println(isMultipleOf3(5, 3, 4));
        System.out.println(isMultipleOf3(13, 8, 1));
        System.out.println(isMultipleOf3(760399384224l, 5, 1));

    }

    //after sometime, while creating digits, the digits tend to repeat themselves (8,6,2,4)
    //if the sum of the digits of a number is divisible by 3, the number is divisible by 3
    //we will start by creating digits until we see the first '8', we will break there and keep the sum
    //we will find the modulo of remaining number of digits with 4 and multiple the result with 20 (8+6+2+4)
    public static boolean isMultipleOf3(long k, int d0, int d1) {
        long digitsLeft = k - 2;
        long sumHere = d0 + d1;
        long prevDigit = 0;
        for (int i = 3; i <= k; i++) {
            sumHere += prevDigit;
            prevDigit = sumHere % 10;
            if (prevDigit == 8) {
                break;
            }
            digitsLeft--;
        }
        long multipleOf8624 = digitsLeft / 4;
        long left = digitsLeft % 4;

        if (left == 1) sumHere += 8;
        else if (left == 2) sumHere += 14;
        else if (left == 3) sumHere += 16;

        sumHere += multipleOf8624 * 20;
        return sumHere % 3 == 0;
    }
}
