package DataStructures.NewWork.TwoPointer;

public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(15));
    }

    public int consecutiveNumbersSum(int N) {
        int start = 1, end = 1, count = 1, sum = 0;

        while (end <= N) {
            sum += end;
            if (sum > N) {
                int val = doBinarySearch(start, end, sum, N);
                if(start != val){
                    sum -= pSum(val - 1, start - 1);
                    start = val;
                } else{
                    if (sum == N) {
                        count++;
                        sum -= start;
                        start++;
                    }
                }
            }

            if (sum == N) {
                count++;
                sum -= start;
                start++;
            }

            end++;
            if (start + end > N) break;
        }

        return count;
    }
//1,2,3,4,5,6,7,8,9,10,11,12,13,14,15

    private int doBinarySearch(int start, int end, int sum, int N) {
        int ans = start;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int ps = pSum(mid, start - 1);
            if (N >= sum - ps) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private int pSum(int mid, int start) {
        int lower = (start * (start + 1)) / 2;
        int midSum = (mid * (mid + 1)) / 2;
        return midSum - lower;
    }

}
