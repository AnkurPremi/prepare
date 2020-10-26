package DataStructures.NewWork.LCArray;

public class FlipImage {
    public static void main(String[] args) {
        int[][] A= {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        new FlipImage().flipAndInvertImage(A);
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] arr : A){
            int x1 = 0, y1 = A.length-1;
            while(x1 < y1){
                int i=1, j=1;
                if(arr[x1] == 1)
                    j=0;
                if(arr[y1] == 1)
                    i=0;
                arr[x1++]=i;
                arr[y1--]=j;
            }
            if(x1 == y1)
                arr[x1] = arr[x1] == 0 ? 1 : 0;
        }
        return A;
    }
}
