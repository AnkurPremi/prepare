package problemsArray;

//https://leetcode.com/problems/jump-game/
public class JumpGame {
    public static void main(String[] args) {
        int[] jumps = {3, 2, 1, 0, 4};
        System.out.println(new JumpGame().canJump(jumps));
    }

    //check-1
    //We will start from the second last position and check if we can jump from this position to last_index
    //check-2: for that we will consider 1 jump from all previous jumps + value of jump at current index
    //if   i + currentJumpValue  >= last_position... that means we can reach to last position from the second last
    //now, we have to check our assumption of check-2.. for that our last_position = second_last_pos...and we will start
    //from check-1
    public boolean canJump(int[] A) {
        int last_position = A.length - 1;
        //we are starting backwords
        for (int i = A.length - 2; i >= 0; i--) {
            //here we are adding i considering all the indices before that will have 1 jump at least
            if(i + A[i] >= last_position){
                last_position = i;
            }
        }
        //after looping back return true if we are the last position ..else return false
        return last_position <= 0;
    }

    public boolean canJump1(int[] A) {
        int farthest_index_possible = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > farthest_index_possible) {
                return false;
            }
            farthest_index_possible = Math.max(A[i] + i, farthest_index_possible);
        }
        return true;
    }
}
