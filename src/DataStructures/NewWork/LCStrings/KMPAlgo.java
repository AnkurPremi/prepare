package DataStructures.NewWork.LCStrings;

public class KMPAlgo {
    public static void main(String[] args) {
        String s = "abxabcabyabc";
        String p = "leetcodeleet";
        new KMPAlgo().test();
//        System.out.println(new KMPAlgo().substringSearch(s, p));
    }

    private void test(){
        int[] dirX = {-1, 0, 1};
        int[] dirY = {-1, 0, 1};
        for(int dx : dirX){
            for(int y : dirY){
                System.out.println("x: " + dx +"  y: "+y);

            }
        }
    }

    public int substringSearch(String s, String p) {
        int[] piTable = prefixTable(p);
        int i = 0, j = 0;
        while(j < p.length()){
            if(p.charAt(j) == s.charAt(i)){
                i++;
                j++;
            } else{
                if(j == 0) i++;
                else j = piTable[j - 1];
            }

            if(j == p.length()){
                return i - j;
            }
        }
        return -1;
    }

    private int[] prefixTable(String pattern){
        int[] pitable = new int[pattern.length()];
        int i = 0, j = 1;
        while(j < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                pitable[j] = i + 1;
                i++;
                j++;
            } else{
                if(i == 0) j++;
                else i = pitable[i-1];
            }
        }
        return pitable;
    }

//    public int substringSearch(String s, String p) {
//        int[] piTable = prepareTable(p);
//
//        int i=0, j=0;
//        while(i < s.length() && j < p.length()){
//            if(s.charAt(i) == p.charAt(j)){
//                i++;
//                j++;
//            } else{
//                if(j == 0) i++;
//                else
//                    j = j-1 >=0 ? piTable[j-1] : 0;
//            }
//
//            if( j == p.length())
//                return i-j;
//        }
//        return -1;
//    }
//
//    public int[] prepareTable(String pattern) {
//        int[] arr = new int[pattern.length()];
//        int i = 0, j = 1;
//        while (j < pattern.length()) {
//            if(pattern.charAt(i) == pattern.charAt(j)){
//                arr[j] = i + 1;
//                i++;
//                j++;
//            } else{
//                if(i == 0)
//                    j++;
//                else
//                    i = arr[i - 1];
//            }
//        }
//        return arr;
//    }
}
