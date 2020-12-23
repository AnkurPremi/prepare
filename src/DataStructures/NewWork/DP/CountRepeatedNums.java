package DataStructures.NewWork.DP;

import java.util.HashSet;
import java.util.Set;

public class CountRepeatedNums {
    public static void main(String[] args) {
        System.out.println(new CountRepeatedNums().numDupDigitsAtMostN(20));
    }

    public int numDupDigitsAtMostN(int N) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 11; i <= N; i++) {
            int num = i;
            int k = 0;
            int yes = 0;
            while (num > 0) {
                int digit = num % 10;
                if ((k & (1 << digit)) != 0) {
                    yes = 1;
                    break;
                }

                k |= 1 << digit;
                num /= 10;
                if (set.contains(num)) {
                    yes = 1;
                    break;
                }
            }
            if (yes == 1) {
                set.add(i);
                count++;
            }
        }
        return count;
    }
}
