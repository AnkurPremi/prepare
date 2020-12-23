package DataStructures.NewWork.LCStrings;

public class StringCompression2 {
    public static void main(String[] args) {
        String s = "aaabcccd";
        System.out.println(new StringCompression2().getLengthOfOptimalCompression(s, 2));
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        int[] counts = new int[26];
        int total = 0;
        int count = 1;
        counts[s.charAt(0) - 'a']++;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                count++;
            else {
                if (count == 1) total += 1;
                else if (count < 10) total += 2;
                else if (count < 100) total += 3;
                else if (count == 100) total += 4;
                count = 1;
            }
            counts[s.charAt(i) - 'a']++;
        }
        if (count == 1) total += 1;
        else if (count < 10) total += 2;
        else if (count < 100) total += 3;
        else if (count == 100) total += 4;

        int[] buckets = new int[101];
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) continue;
            buckets[counts[i]]++;
        }

        for (int i = 1; i < 101; i++) {
            if (buckets[i] == 0) continue;
            if (buckets[i] * i == k) {
                if (i == 1) total -= buckets[i];
                else if (i < 10) total -= 2 * buckets[i];
                else if (i < 100) total -= 3 * buckets[i];
                else if (i == 100) total -= 4 * buckets[i];
                return total;
            } else if (buckets[i] * i > k) {
                if (i == 1) total -= buckets[i];
                else if (i < 10) total -= 2 * buckets[i];
                else if (i < 100) total -= 3 * buckets[i];
                else if (i == 100) total -= 4 * buckets[i];
                k -= buckets[i] * i;
            } else {
                while (k > 0) {
                    int val = buckets[i];
                    int chars = i;
                    while (k > 0 && chars > 0) {
                        chars--;
                        k--;
                    }
                    if (k == 0) {
                        if (i == 1) total -= buckets[i];
                        else if (i < 10) total -= 2 * buckets[i];
                        else if (i < 100) total -= 3 * buckets[i];
                        else if (i == 100) total -= 4 * buckets[i];
                    }
                }
            }
        }
        return 2;
    }
}
