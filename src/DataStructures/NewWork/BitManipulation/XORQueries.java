package DataStructures.NewWork.BitManipulation;

public class XORQueries {
    public static void main(String[] args) {

        int n = 14 & -14;
        System.out.println(Integer.toBinaryString(14));
        System.out.println(Integer.toBinaryString(-14));
        System.out.println(Integer.toBinaryString(n));

        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
        int[] arr = {1,3,4,8};
        arr = new XORQueries().xorQueries(arr, queries);
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        for(int i=1 ; i<prefix.length ; i++){
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for(int[] query : queries){
            ans[i++] = prefix[query[1]+1] ^ prefix[query[0]];
        }
        return ans;
    }
}
