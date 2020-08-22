package codechef.LinearDS;

//https://www.codechef.com/LRNDSA02/problems/COMPILER
public class MaxLengthBalancedSqrBrackets {
    public static void main(String[] args) {
        String s = "<<>>";
        String s1 = "><";
        String s2 = "<>>>";
        String s3 = ">><><>";
        System.out.println(getMaxLength(s));
        System.out.println(getMaxLength(s1));
        System.out.println(getMaxLength(s2));
        System.out.println(getMaxLength(s3));
    }

    public static int getMaxLength(String s) {
        if (s != null && !s.isEmpty()) {
            int maxOpenB = Integer.MIN_VALUE;
            int openBNow = 0;
            int value = 0;
            for (char c : s.toCharArray()) {
                if (c == '<') {
                    openBNow++;
                    value++;
                } else {
                    value--;
                }
                if (value == -1) {
                    openBNow = 0;
                    value = 0;
                } else if (value == 0) {
                    maxOpenB = Math.max(maxOpenB, openBNow);
                    openBNow = 0;
                }
            }
            return maxOpenB != Integer.MIN_VALUE ? 2 * maxOpenB : 0;
        }
        return 0;
    }
}
