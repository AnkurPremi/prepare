package SortingAndSeraching;

/**
 * Given a string s and an integer array indices of the same length.
 *
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Return the shuffled string.
 */
public class RestoreString {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        restoreString(s, indices);
    }

    static String restoreString(String s, int[] indices) {
        char[] c = new char[indices.length];
        for(int i = 0; i < indices.length; i++)
            c[indices[i]] = s.charAt(i);
        return new String(c);
    }
    static String restoreString1(String s, int[] indices) {
        char[] str = sort(s.toCharArray(), indices, 0, s.length()-1);
        System.out.println(str);
        return new String(str);
    }

    static char[] sort(char[] s, int[] indices, int start, int end){
        if(start >=end ) return s;
        int pivotIndex = partition(s,  indices,  start,  end);
        sort(s, indices, start, pivotIndex-1);
        sort(s, indices, pivotIndex+1, end);
        return s;
    }

    static int partition(char[] s, int[] indices, int start, int end){
        int pivot = indices[end];
        int pIndex = start;
        for(int i=start; i<end ; i++){
            if(indices[i] <= pivot){
                swap(s, indices, i, pIndex);
                pIndex++;
            }
        }
        swap(s, indices, pIndex, end);
        return pIndex;
    }

    static void swap(char[] s, int[] indices, int i, int j){
        int temp = s[i];
        s[i] = s[j];
        s[j] = (char)temp;

        temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }
}
