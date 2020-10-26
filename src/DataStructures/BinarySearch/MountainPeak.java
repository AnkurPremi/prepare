package DataStructures.BinarySearch;

public class MountainPeak {
    public static void main(String[] args) {
        int[] arr = {3,5,3,2,0};
        System.out.println(new MountainPeak().peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {

        int l = 0, r = arr.length-1;
        while(l < r){
            int m = (l+r) >> 1;
            if(m == 0) return m+1;
            if(m == arr.length-1) return m-1;
            if(arr[m] > arr[m-1] && arr[m] > arr[m+1])
                return m;
            else if(arr[m-1] > arr[m])
                r = m - 1;
            else
                l = m + 1;
        }
        return l;
    }
}
