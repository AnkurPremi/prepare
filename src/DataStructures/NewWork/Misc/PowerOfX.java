package DataStructures.NewWork.Misc;

import java.util.HashMap;
import java.util.Map;

public class PowerOfX {
    public static void main(String[] args) {
        System.out.println(new PowerOfX().myPow(2.0, 10));
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;

        int baseSign = 1, powerSign = 1;
        if (x < 0) {
            baseSign = -1;
            x = -x;
        }

        if (n < 0) {
            powerSign = -1;
            n = -n;
        }

        double val = pow(x, n, new HashMap());
        if (baseSign == 1 && powerSign == 1) return val;
        else if (baseSign == 1) return 1.0 / val;
        else if (powerSign == 1) {
            if (n % 2 == 0) return val;
            else return -val;
        } else {
            if (n % 2 == 0) return 1.0 / val;
            else return -1.0 / val;
        }

    }

    private double pow(double x, int n, Map<Integer, Double> cache) {
        if (n == 1) return x;
        if (cache.containsKey(n)) return cache.get(n);

        double val = 0.0;

        if ((n & 1) == 1) {
            val = pow(x, n / 2, cache) * pow(x, n / 2, cache) * x;
        } else {
            val = pow(x, n / 2, cache) * pow(x, n / 2, cache);
        }

        cache.put(n, val);

        return val;
    }
}
