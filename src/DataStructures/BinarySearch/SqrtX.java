package DataStructures.BinarySearch;

public class SqrtX {
    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(8));
    }

    public int mySqrt(int x) {
        double l = 1d;
        double r = x / 2;
        while (l <= r) {
            double m = (r - l) / 2 + l;
            double sqrd = m * m;
            if ((int) sqrd == x)
                return (int) m;
            else if ((int) sqrd < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return (int) l;
    }
}
