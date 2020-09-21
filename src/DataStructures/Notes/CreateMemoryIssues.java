package DataStructures.Notes;

public class CreateMemoryIssues {
    public static void main(String[] args) {
        createArr(100);
    }

    static void createArr(int count){
        if(count == 0) return;
        Integer[] arr = new Integer[Integer.MAX_VALUE];
        System.out.println("created: "+count);
        createArr(count--);
    }
}
