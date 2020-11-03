package DataStructures.NewWork.LCStrings;

public class NextGreaterElement {
    public static void main(String[] args) {
        int num = 17654321;
        System.out.println(new NextGreaterElement().nextGreaterElement(num));
    }

    public int nextGreaterElement(int n) {
        if (n < 10) return -1;
        String s = String.valueOf(n);
        int min = s.charAt(0) - '0';
        int max = 10;
        int[] counts = new int[10];
        counts[min]++;
        //find the last index of the element just greater than 1st digit
        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            counts[num]++;
            if (num > min && num <= max) {
                max = num;
            }
        }

        if (max == 10) return -1;

        char[] arr = new char[s.length()];
        counts[max]--;
        arr[0] = (char) (max + '0');
        int writer = 1;
        for (int i = 0; i < 10; i++) {
            int val = counts[i];
            while (val-- > 0) {
                arr[writer++] = (char) (i + '0');
            }
        }

        long ans = Long.parseLong(new String(arr));
        if (ans >= Integer.MAX_VALUE)
            return -1;

        return (int) ans;
    }
}
