package DataStructures.HashTable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        new RepeatedDNASequences().andNum();
        int num = new RepeatedDNASequences().createMask(20);
        String s = "11111111111111111111";
//        int n = Integer.parseInt("0xfffff",16);
//        System.out.print(Integer.toBinaryString(n));
//        System.out.println("");
        String a = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences(a));
    }

    //This is a sort of queue ..where A is 00, C-01, G-10, T-11
    //we first ..start adding the values to the number..by bit mask and bit shift
    //when we reach 10 length (which is same as 20 bits in binary)... we need to check if we have seen this earlier
    //for next incoming character (11th position).. we will need to remove the character at the beginning.. to keep the length of the queue to 10
    //to drop the first character.. we did value &= 0xfffff (1048575  or binary 11111111111111111111) ..which is 20 set bits
    //the first character is represented by 2 bits...so to drop the first 2 bits from 22 bits number...we used above logic
    //Eg: 11101011111111111011 -- 20 bits (10 characters)
    //    1110101111111111101100 -- 22 bits (11 characters)..
    //    1110101111111111101100  -- do And operation
    //  &   11111111111111111111  -- with 20 set bits
    //Ans:  10101111111111101100  -- First 2 bits are dropped from 22 bit number
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<Integer> word = new HashSet<>();
        Set<Integer> secondWord = new HashSet<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value <<= 2;
            value |= map[s.charAt(i) - 'A'];
            System.out.println(Integer.toBinaryString(value));
            value &= 1048575;//1048575, 0xfffff
            System.out.println(Integer.toBinaryString(value));
            if (i < 9) {
                continue;
            }
            if (!word.add(value) && secondWord.add(value)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }
        return result;
    }

    public int createMask(int count){
        int val = 0;
        for(int i=0 ; i<count ; i++){
            val = (val << 1) | 1;
        }
        return val;
    }

    public void andNum(){
        int num = 1;
        for(int i=1; i < 2048 ; i++){
            num &= i;
            System.out.println(num);
        }
    }
}
