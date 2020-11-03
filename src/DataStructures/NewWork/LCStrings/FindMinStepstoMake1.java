package DataStructures.NewWork.LCStrings;

public class FindMinStepstoMake1 {
    public static void main(String[] args) {
        String s  = "101010101101";
        System.out.println(new FindMinStepstoMake1().numSteps(s));
    }

    public int numSteps(String s) {
        int count = 0;
        int num = 0;
        for(int i=s.length()-1 ; i>0 ; i--){
            if((s.charAt(i) - '0' + num) % 2 == 0){
                count++;
                num = 0;
            }
            else{
                if(s.charAt(i) - '0' == 0) num = 0;
                else num = 1;
                count += 2;
            }
        }
        return count;
    }
}
