package DataStructures.NewWork.LCStrings;

public class SplitStrings {
    public static void main(String[] args) {
        String s = "aacaba";
        System.out.println(new SplitStrings().numSplits(s));
    }

    public int numSplits(String s) {
        int[] left = new int[s.length()];
        int[] mapLeft = new int[26];
        int[] mapRight = new int[26];
        int leftCount = 0, rightCount = 0;
        int count = 0;
        for(int i=0 ; i<s.length() ; i++){
            if(mapLeft[s.charAt(i) - 'a'] == 0){
                mapLeft[s.charAt(i) - 'a'] = 1;
                leftCount++;
            }
            left[i] = leftCount;
        }

        for(int i=s.length()-1 ; i>0 ; i--){
            if(mapRight[s.charAt(i) - 'a'] == 0){
                mapRight[s.charAt(i) - 'a'] = 1;
                rightCount++;
            }
            if(rightCount == left[i-1])
                count++;
        }

        return count;
    }
}
