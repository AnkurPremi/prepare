package codechef.LinearDS;

//https://www.codechef.com/LRNDSA02/problems/ZCO12001
public class Matched_Brackets {
    public static void main(String[] args) {
        String s = "()(())()(()())(()())";
        int[] result = getAllDetails(s);
        System.out.println("check results");
    }

    public static int[] getAllDetails(String s) {
        if (s != null && !s.isEmpty()) {
            int[] result = new int[4];
            int maxDepth = Integer.MIN_VALUE;
            int maxSymbols = Integer.MIN_VALUE;
            int idxFirstResult = -1;
            int idxSecondResult = -1;
            int openBNow = 0;
            int value = 0;
            boolean isCounting = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    openBNow++;
                    value++;
                } else {
                    value--;
                    //val > 0: shows there is one open bracket
                    //isCounting: shows that maxSymbol is being counted now
                    //this will not work for all open bracket inside already open bracket
                    if (value > 0 && !isCounting) {
                        isCounting = true;
                        idxSecondResult = i - 2;
                    }
                }
                if (value == -1) {
                    openBNow = 0;
                    value = 0;
                    isCounting = false;
                } else if (value == 0) {
                    int val = maxDepth;
                    maxDepth = Math.max(maxDepth, openBNow);
                    if (maxDepth > val) {
                        idxFirstResult = i - (maxDepth * 2) + 1;
                        idxFirstResult = Math.max(idxFirstResult, 0);
                        result[1] = idxFirstResult;
                        result[0] = maxDepth;
                    }
                    openBNow = 0;
                    if (isCounting) {
                        int val1 = maxSymbols;
                        maxSymbols = Math.max(maxSymbols, (i - idxSecondResult + 1));
                        if (maxSymbols > val1) {
                            result[2] = maxSymbols;
                            result[3] = idxSecondResult;
                        }
                    }
                    isCounting = false;
                }
            }
            return result;
        }
        return null;
    }
}
