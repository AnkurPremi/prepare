package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.List;

public class BreakStringForFibSeq {
    public static void main(String[] args) {
        String s = "11235813";
        System.out.println(new BreakStringForFibSeq().splitIntoFibonacci(s));
    }

    public List<Integer> splitIntoFibonacci(String s) {
        List<Integer> result = new ArrayList();
        int n = s.length();

        for (int i = 0; i < n - 2; i++) {
            int a = Integer.parseInt(s.substring(0, i + 1));
            for (int j = i + 1; j < n - 1; j++) {
                int b = Integer.parseInt(s.substring(i + 1, j + 1));
                boolean found = false;
                for (int k = j + 1; k < n; k++) {
                    int c = Integer.parseInt(s.substring(j+1, k + 1));
                    if (a + b == c) {
                        result.add(a);
                        result.add(b);
                        result.add(c);
                        a = b;
                        b = c;
                        found = true;
                        if(k == n-1) return result;
                    } else {
                        result.clear();
                        if (found || c > a+b) break;
                    }
                }
            }
        }
        return result;
    }
}
