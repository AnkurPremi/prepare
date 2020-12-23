package DataStructures.Mock;

public class ISBadVersion {
    public static void main(String[] args) {
        System.out.println(new ISBadVersion().firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        long start = 1, end = n;
        while(start <= end){
            long mid = (end - start)/2 + start;
            if(isBadVersion((int)mid)){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return (int)start;
    }

    private boolean isBadVersion(int n){
        return (n >= 1702766719);
    }
}
