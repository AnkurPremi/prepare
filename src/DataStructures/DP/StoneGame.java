package DataStructures.DP;

public class StoneGame {
    public static void main(String[] args) {
        int[] arr = {5,3,4,5,5,3};
        System.out.println(new StoneGame().stoneGame(arr));
    }

    public boolean stoneGame(int[] piles) {
        int start = 0;
        int end = piles.length-1;
        int A = 0;
        boolean ac = true;
        while(start < end){
            int val = 0;
            if(piles[start] < piles[end]){
                val = piles[end];
                end--;
            }else if(piles[start] > piles[end]){
                val = piles[start];
                start++;
            }else{
                int i = start;
                int j = end;
                while(i <= j){
                    if(piles[i] > piles[j]){
                        val = piles[end];
                        end--;
                        break;
                    }else if(piles[i] < piles[j]){
                        val = piles[start];
                        start++;
                        break;
                    }else{
                        i++;
                        j--;
                    }
                }
                if(i > j) return A > 0;
            }
            if(ac){
                A+=val;
                ac = false;
            }else{
                A-=val;
                ac = true;
            }
        }
        return A > 0;
    }
}
