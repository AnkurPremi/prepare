package DataStructures.NewWork.DP;

public class PushDominoes {
    public static void main(String[] args) {
        String s = ".L.R...LR..L..";
        System.out.println(new PushDominoes().pushDominoes(s));
    }

    public String pushDominoes(String dominoes) {
        //we will find the balancing forces
        int n = dominoes.length();

        //move left to right ..and
        int[] forcesLeftToRight = new int[n];
        int maxRightForce = Integer.MAX_VALUE;
        int forceHere = 0;
        for(int i=0 ; i<n ; i++){
            if(dominoes.charAt(i) == 'R'){
                forceHere = maxRightForce;
            }
            if(dominoes.charAt(i) == 'L'){
                forceHere = 0;
            }
            forcesLeftToRight[i] = forceHere == 0 ? 0 : forceHere--;
        }

        //move right to left
        int[] forcesRightToLeft = new int[n];
        int maxLeftForce = Integer.MIN_VALUE;
        forceHere = 0;
        for(int i=n-1 ; i>=0 ; --i){
            if(dominoes.charAt(i) == 'L'){
                forceHere = maxLeftForce;
            }
            if(dominoes.charAt(i) == 'R'){
                forceHere = 0;
            }
            forcesRightToLeft[i] = forceHere == 0 ? 0 : forceHere++;
        }

        char[] arr= dominoes.toCharArray();

        for(int i=0 ; i<n ; i++){
            int val = forcesLeftToRight[i] + forcesRightToLeft[i];
            if(val < 0)
                arr[i] = 'L';
            else if(val > 0)
                arr[i] = 'R';
            else
                arr[i] = '.';
        }

        return String.valueOf(arr);
    }
}
