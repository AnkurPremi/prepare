package DataStructures.Hackerrank;

public class Staircase {
    public static void main(String[] args) {
        new Staircase().printStaircase(4);
    }

    public void printStaircase(int n){
        if(n == 0) return;
        StringBuilder builder = new StringBuilder();
        while(n > 0){
            n--;
            builder.append("#");
            System.out.println(builder.toString());
        }
    }
}
