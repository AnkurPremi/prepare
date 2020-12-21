package DataStructures.NewWork.LCArray;

public class MaxTurbulenceArraySize {
    public static void main(String[] args) {
        int[] arr = {8,8,9,10,6,8,2,4,2,2,10,6,6,10,10,2,3,5,1,2,10,4,2,0,9,4,9,3,0,6,3,2,3,10,10,6,4,6,4,4,2,5,1,4,1,1,9,8,9,5,3,5,5,4,5,5,6,5,3,3,7,2,0,10,9,7,7,3,5,1,0,9,6,3,1,3,4,4,3,6,3,2,1,4,10,2,3,4,4,3,6,7,6,2,1,7,0,6,8,10};
//        int[] arr = {9,4,2,10,7,8,8,1,9};
        System.out.println(new MaxTurbulenceArraySize().maxTurbulenceSize(arr));
    }

    public int maxTurbulenceSize(int[] A) {
        int ans = 0;
        int max = 0;
        for(int i=1 ; i<A.length ; i++){
            if(A[i] > A[i-1])
                ans = ans > 0 ? ans + 1 : 1;
            else if(A[i] < A[i-1])
                ans = ans < 0 ? ans - 1 : -1;
            else
                ans = 0;
            ans *= -1;
            max = Math.max(max, Math.abs(ans));
        }

        return max + 1;
    }

    public int maxTurbulenceSize1(int[] A) {
        int max = 1;
        int kOddGreater = 1;
        int kEvenGreater = 1;
        for(int i=0; i<A.length-1 ; i++){
            if(i%2 == 0){
                if(A[i] > A[i+1]){
                    max = Math.max(kOddGreater, max);
                    kOddGreater = 1;
                    kEvenGreater++;
                } else if(A[i] < A[i+1]){
                    max = Math.max(kEvenGreater, max);
                    kOddGreater++;
                    kEvenGreater = 1;
                }else{
                    max = Math.max(max, Math.max(kEvenGreater,kOddGreater));
                    kOddGreater = 1;
                    kEvenGreater = 1;
                }
            } else{
                if(A[i] > A[i+1]){
                    max = Math.max(kEvenGreater, max);
                    kOddGreater++;
                    kEvenGreater = 1;
                }else if(A[i] < A[i+1]){
                    max = Math.max(kOddGreater, max);
                    kOddGreater = 1;
                    kEvenGreater++;
                }else{
                    max = Math.max(max, Math.max(kEvenGreater,kOddGreater));
                    kOddGreater = 1;
                    kEvenGreater = 1;
                }
            }
        }
        return Math.max(max, Math.max(kEvenGreater,kOddGreater));
    }
}
