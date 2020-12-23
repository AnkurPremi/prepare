package DataStructures.NewWork.DP;

public class PartitionKEqualSumSubSets {
    public static void main(String[] args) {
        int[] arr = {10,10,10,7,7,7,7,7,7,6,6,6};
        System.out.println(new PartitionKEqualSumSubSets().canPartitionKSubsets(arr, 3));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int[] arr = new int[10001];
        for (int num : nums) {
            arr[num]++;
            sum += num;
        }

        int partVal = sum / k;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                while (arr[i] > 0) {
                    int sumHere = i;
                    if (sumHere == partVal) {
                        arr[i]--;
                        k--;
                    } else {
                        while (sumHere < partVal) {
                            int req = partVal - sumHere;
                            if (arr[req] == 0) return false;
                            arr[req]--;

                            sumHere += req;
                            if (sumHere == partVal) {
                                k--;
                                arr[i]--;
                                break;
                            }
                        }
                        if (sumHere > partVal) return false;
                    }
                }
            }

        }

        return k == 0;
    }
}
