//package DataStructures.problemsArray;
//
//public class ArrayInversion {
//    public static void main(String[] args) {
//
//    }
//
//    int count = 0;
//    public int getArrayInversion(int[] arr, int l, int r){
//        if(l > r) return 0;
//        int m = (l+r) >>1;
//        getArrayInversion(arr, l, m-1);
//        getArrayInversion(arr, m+1, r);
//        getInversions(arr, l, m, r);
//        return count;
//    }
//
//    public int getInversions(int[] arr, int l, int m, int r){
//        if(l>m || r<m) return 0;
//        if(arr[l] > arr[r]){
//            r++;
//            count += getInversions(arr, l, m, r);
//        }else {
//            l++;
//        }
//    }
//}
