package DataStructures.NewWork.LCArray;

public class BestSightSeeingaPair {
    public static void main(String[] args) {
        int[] arr = {8,1,5,2,6};
        System.out.println(new BestSightSeeingaPair().maxScoreSightseeingPair(arr));
    }

    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        for (int j = 1, max_i = A[0] - 1; j < A.length; ++j, --max_i) {
            res = (res > A[j] + max_i) ? res : A[j] + max_i;
            max_i = (max_i > A[j]) ? max_i : A[j];
        }
        return res;
    }
}
