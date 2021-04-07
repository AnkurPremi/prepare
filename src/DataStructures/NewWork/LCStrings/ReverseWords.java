package DataStructures.NewWork.LCStrings;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(new ReverseWords().reverseWords(s));
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int start = 0, end = 0;
        int n = s.length();

        while(end < n){
            if(end != 0 && end != n - 1 && arr[end] == ' '){
                arr[start] = ' ';
                start++;
                end++;
                while(end < n && arr[end] == ' ') end++;

            } else{
                arr[start] = arr[end];
                start++;
                end++;
            }
        }

        n = start; start = 0; end = 0;

        while(end < n){
            while(end < n && arr[end] != ' '){
                end++;
            }
            reverse(arr, start, end - 1);
            end++;
            start = end;
        }

        reverse(arr, 0, n - 1);
        return String.valueOf(arr, 0, n);
    }

    private void reverse(char[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] arr, int start, int end){
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
