package DataStructures.codechef;

public class ReverseNumber {
    public static void main(String[] args) {
        int num = 12345;
        System.out.println(reverseNum(num));
    }

    public static long reverseNum(int num){
        long newNum =0l;
        while(num > 0){
            newNum = newNum*10 + num%10;
            num /= 10;
        }
        return newNum;
    }
}
