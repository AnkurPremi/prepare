package DataStructures.NewWork.LCStrings;

public class CheckWordAfterABCSubs {
    public static void main(String[] args) {
        String s = "aabcbabcabcc";
        System.out.println(new CheckWordAfterABCSubs().isValid(s));
    }

    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        for(int j=0 ; j<arr.length ; j++){
            if(arr[j] == 'c'){
                if(i<2) return false;
                if(arr[i-1] == 'b' && arr[i-2] == 'a')
                    i = i-2;
                else return false;
            } else{
                arr[i++] = arr[j];
            }
        }
        return i == 0;
    }
}
