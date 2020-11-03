package DataStructures.NewWork.LCStrings;

public class KMPAlgo {
    public static void main(String[] args) {
        String s = "abxabcabyabc";
        String p = "abcaby";
        System.out.println(new KMPAlgo().substringSearch(s, p));
    }

    public int substringSearch(String s, String p) {
        int[] piTable = prepareTable(p);

        int i=0, j=0;
        while(i < s.length() && j < p.length()){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            } else{
                if(j == 0) i++;
                else
                    j = j-1 >=0 ? piTable[j-1] : 0;
            }

            if( j == p.length())
                return i-j;
        }
        return -1;
    }

    public int[] prepareTable(String pattern) {
        int[] arr = new int[pattern.length()];
        int i = 0, j = 1;
        while (j < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)){
                arr[j] = i + 1;
                i++;
                j++;
            } else{
                if(i == 0)
                    j++;
                else
                    i = arr[i - 1];
            }
        }
        return arr;
    }
}
