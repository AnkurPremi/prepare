package DataStructures.NewWork.LCArray;

public class MinFlipReq {
    public static void main(String[] args) {
        String s = "01010011";
        System.out.println(new MinFlipReq().minFlipsMonoIncr(s));
    }


    public int minFlipsMonoIncr(String S) {
        int flipCount = 0;
        int onesCount = 0;
        for(char c : S.toCharArray()){
            if(c == '0'){
                if(onesCount == 0) continue;
                flipCount++;
            }else{
                onesCount++;
            }

            //check if flipping ones is minimum or ones
            if(flipCount > onesCount){
                flipCount = onesCount;
            }
        }

        return flipCount;

//         int result = Integer.MAX_VALUE;
//        int n = S.length();
//        int[] zeroToOne = new int[n + 1];
//        int[] oneToZero = new int[n + 1];
//        for (int i = 1, j = n - 1; j >= 0; i++, j--) {
//            zeroToOne[i] = zeroToOne[i - 1] + S.charAt(i-1) == '0' ? 0 : 1;
//            oneToZero[j] = oneToZero[j + 1] + S.charAt(j) == '1' ? 0 : 1;
//        }
//
//        for (int i = 1; i < n + 1; i++) {
//            result = Math.min(result, oneToZero[i] + zeroToOne[i]);
//        }
//        return result;
        //return 0;
    }
}
