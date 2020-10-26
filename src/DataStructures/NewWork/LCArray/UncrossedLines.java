package DataStructures.NewWork.LCArray;

public class UncrossedLines {
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 1, 2};
        int[] B = {1, 3, 2, 3, 1};
        System.out.println(new UncrossedLines().maxUncrossedLines(A, B));
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int count = 0;
        int startJ = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = startJ; j < B.length; j++) {
                if (A[i] == B[j]) {
                    count++;
                    if (j == B.length - 1) {
                        max = Math.max(max, count);
                        count--;
                        i++;
                    } else {
                        startJ = j + 1;
                    }
                }
            }
        }
        return Math.max(max, count);
    }
}
