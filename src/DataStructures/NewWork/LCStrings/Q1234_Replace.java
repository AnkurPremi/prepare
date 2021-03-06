package DataStructures.NewWork.LCStrings;

public class Q1234_Replace {
    public static void main(String[] args) {
        System.out.println(Q1234_Replace.steadyGene("GAAATAAA"));
    }

    static int steadyGene(String s) {
        int n = s.length(), k = n / 4;
        int[] counts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }

        //if all are balanced
        if (isBalanced(counts, k)) return 0;

        //there are some characters where frequency is more than k
        //we need to find a window - where removing the extra freq..will bring all the freq  <= k
        //we need to find the min size of that window

        int i = 0, min = n;
        for (int j = 0; j < n; j++) {
            counts[s.charAt(j)]--;
            //left part + right part of this window is balanced (extra characters are reduced to less than k)
            //reduce the size by contracting this window from left
            while (isBalanced(counts, k)) {
                min = Math.min(min, j - i + 1);
                counts[s.charAt(i)]++;
                i++;
            }
        }
        return min;
    }

    static boolean isBalanced(int[] counts, int k) {
        return counts['G'] <= k && counts['A'] <= k && counts['T'] <= k && counts['C'] <= k;
    }
}
