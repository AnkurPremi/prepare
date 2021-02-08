package DataStructures.BitManipulation;

public class CommonTasks {

//    a = 0011 1100
//    b = 0000 1101
//    a&b = 0000 1100
//    a|b = 0011 1101
//    a^b = 0011 0001
//      ~a  = 1100 0011

    public static void main(String[] args) {
        powerOf2();
//        if(getBit(127, 1)){
//            System.out.println("4th digit is 1");
//        }else{
//            System.out.println("4th digit is 0");
//        }
//        System.out.println("-----------------------------------");
//        System.out.println(Integer.toBinaryString(setBit(127, 4)));
//        System.out.println(Integer.toBinaryString(127));
//        System.out.println(Integer.toBinaryString(clearBit(127, 4)));
    }

    //0th index based
    public static boolean getBit(int num, int i){
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(1 << i));
        return ((num & (1 << i)) !=0 );
    }

    //0th index based
    //only if there is 0 change it to 1, if 1 then leave it
    public static int setBit(int num, int i){
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(1 << i));
        System.out.println(Integer.toBinaryString(num));
        return (num | (1 << i));
    }

    //0th index based
    public static int clearBit(int num, int i){
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(1 << i));
        System.out.println(Integer.toBinaryString(~(1 << i)));
        System.out.println(Integer.toBinaryString(num));
        return (num & ~(1 << i));
    }

    public static void powerOf2(){
        int num = 2048;
        System.out.println((num & (num - 1)) == 0);
    }
}
