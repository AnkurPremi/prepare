package DataStructures.stacks;

public class CheckIfWordIsValidAfterSubstitutions {
    public static void main(String[] args) {
        String s = "abcabcababcc";
        System.out.println(new CheckIfWordIsValidAfterSubstitutions().isValid(s));
    }

    public boolean isValid(String target) {

        if(target.length() < 3) return false;
        int i = 0;
        char[] arr = target.toCharArray();
        for(char c : arr){
            if(i < 2 && c == 'c') return false;
            else if(c == 'c'){
                if(arr[i-2] == 'a' && arr[i-1] == 'b'){
                    i = i-2;
                }else{
                    return false;
                }
            }else{
                arr[i] = c;
                i++;
            }
        }
        return i == 0;
    }
}
