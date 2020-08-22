package strings;

public class RabinKarpStringAlgo {
    public static void main(String[] args) {
        String s = "acdbadabc";
        String p = "abc";
        containsSubstring(s, p);
    }

    public static boolean containsSubstring(String s, String p) {
        long hash = calculateHash(p, 0, p.length() - 1, 3, 0, p.length());
        int i = 0, j = p.length() - 1;
        long previousHash = 0;
        while (j < s.length()) {
            long currHash = calculateHash(s, i, j, 3, previousHash, p.length());
            // calculate if both the hash are same,
            // if yes then compare the pattern with the substring in s starting at i
            // if no, then repeat the same process for other substring
            if (currHash == hash && checkSameString(s, i, p)) {
                return true;
            } else {
                previousHash = currHash;
            }
            i++;
            j++;
        }
        return true;
    }

    private static boolean checkSameString(String s, int start, String p) {
        for (int i = 0; i < p.length(); i++) {
            if (s.charAt(start + i) != p.charAt(i))
                return false;
        }
        return true;
    }

    public static long calculateHash(String s, int start, int end, int prime, long previousHash, int len) {
        long hash = 0l;

        //this is rolling hash
        if (previousHash != 0l) {
            previousHash = previousHash - (long) s.charAt(start - 1);
            previousHash = previousHash / prime;
            long primeVal = Double.valueOf(Math.pow(prime, len - 1)).longValue();
            return previousHash + s.charAt(end) * primeVal;
        }
        //this is initial hash calculation
        else {
            int val = 0;
            for (int i = start; i <= end; i++) {
                hash += s.charAt(i) * Double.valueOf(Math.pow(prime, val)).longValue();
                val++;
            }
        }
        return hash;
    }

}
