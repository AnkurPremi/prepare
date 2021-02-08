package DataStructures.NewWork.LCStrings;

public class FractionAdd {
    public static void main(String[] args) {
        String s = "-1/2+1/2+1/3";
        System.out.println(new FractionAdd().fractionAddition(s));
    }

    public String fractionAddition(String expression) {
//        String s2 = "asdadsasdad_asdasdad+adasdasd=dasdasd#sadas";
//        String[] tok = s2.split(("(?=[_+=#])"));
        String[] tokens = expression.split("(?=[+-])");
        int len = tokens.length;
        int[] numerators = new int[len];
        int[] denominators = new int[len];
        for (int i = 0; i < len; i++) {
            numerators[i] = Integer.parseInt(tokens[i].split("/")[0]);
            denominators[i] = Integer.parseInt(tokens[i].split("/")[1]);
        }
        long denominator = 1, numerator = 0;
        for (int i = 0; i < len; i++) {
            denominator *= denominators[i];
        }
        for (int i = 0; i < len; i++) {
            numerator += denominator * numerators[i] / denominators[i];
        }
        long A = Math.abs(gcd(denominator, numerator));
        String res = numerator / A + "/" + denominator / A;
        return res;
    }
    private long gcd (long x , long y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
}
