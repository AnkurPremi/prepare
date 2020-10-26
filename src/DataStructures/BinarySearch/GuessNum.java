package DataStructures.BinarySearch;

public class GuessNum {
    public static void main(String[] args) {
        int i = 2126753390;
        System.out.println(new GuessNum().guessNumber(i));
    }

    public int guessNumber(int n) {
        long l = 1, r = n;
        while(l < r){
            int m = (int)((l+r) >> 1);
            System.out.println("l="+l+"    m="+m + "    r="+r);
            int v = guess(m);
            if(v == 0)
                return m;
            else if(v == -1)
                r = m - 1;
            else
                l = m + 1;
        }
        return (int)l;
    }

    public int guess(int n){
        if(n == 1702766719) return 0;
        else if(n < 1702766719) return 1;
        else return -1;
    }
}
