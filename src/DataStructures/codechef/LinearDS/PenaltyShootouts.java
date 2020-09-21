package DataStructures.codechef.LinearDS;

//https://www.codechef.com/LRNDSA02/problems/PSHOT
public class PenaltyShootouts {
    public static void main(String[] args) {
        String s = "101011";
        int shot = 3;
//        System.out.println(getMinShotsToDecideWinner(s, shot));
        s = "100001";
        System.out.println(getMinShotsToDecideWinner(s, shot));
    }

    public static int getMinShotsToDecideWinner(String s, int shots) {
        int chanceA = shots, chanceB = shots, shotsA = 0, shotsB = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                shotsA++;
            }
            chanceA--;
            i++;
            if (s.charAt(i) == '1') {
                shotsB++;
            }
            chanceB--;
            i++;
            if (shotsA - chanceB > shotsB) {
                System.out.println("A is the winner");
                return i;
            } else if (shotsB - chanceA > shotsA) {
                System.out.println("A is the winner");
                return i;
            }
        }
        return 2 * shots;
    }
}
