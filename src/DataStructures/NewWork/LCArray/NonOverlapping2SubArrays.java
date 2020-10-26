package DataStructures.NewWork.LCArray;

public class NonOverlapping2SubArrays {
    public static void main(String[] args) {
        int[] arr = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        System.out.println(new NonOverlapping2SubArrays().maxSumTwoNoOverlap(arr, 1, 2));
    }

    public int maxSumTwoNoOverlap1(int[] A, int L, int M) {
        int l = 0, r = 0;
        int sum = 0, maxL = 0, maxM = 0, totalMax = 0;
        int start = 0;
        //first find L then M
        while (r < A.length) {
            sum += A[r];
            if (r - l + 1 >= L) {
                if (maxL < sum) {
                    maxL = sum;
                    start = l;
                }
                sum -= A[l];
                l++;
            }
            r++;
        }
        l = 0;
        r = 0;
        sum = 0;
        while (r < start) {
            sum += A[r];
            if (r - l + 1 >= M) {
                if (maxM < sum) {
                    maxM = sum;
                }
                sum -= A[l];
                l++;
            }
            r++;
        }

        totalMax = Math.max(totalMax, maxL + maxM);

        l = 0;
        r = 0;
        sum = 0;
        maxL = 0;
        maxM = 0;
        while (r < A.length) {
            sum += A[r];
            if (r - l + 1 >= M) {
                if (maxL < sum) {
                    maxL = sum;
                    start = l;
                }
                sum -= A[l];
                l++;
            }
            r++;
        }
        l = 0;
        r = 0;
        sum = 0;
        while (r < start) {
            sum += A[r];
            if (r - l + 1 >= L) {
                if (maxM < sum) {
                    maxM = sum;
                }
                sum -= A[l];
                l++;
            }
            r++;
        }

        return Math.max(totalMax, maxL + maxM);
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = A[i] + preSum[i];
        }
        int lMax = preSum[L], mMax = preSum[M];
        int res = preSum[L + M];
        for (int i = L + M; i <= n; i++) {
            //case 1: L subarray is always before M subarray
            lMax = Math.max(lMax, preSum[i - M] - preSum[i - M - L]);
            //case 2: M subarray is always before L subarray
            mMax = Math.max(mMax, preSum[i - L] - preSum[i - M - L]);
            //compare two cases and update res
            res = Math.max(res, Math.max(lMax + preSum[i] - preSum[i - M], mMax + preSum[i] - preSum[i - L]));
        }
        return res;
    }
}
