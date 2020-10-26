package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.List;

public class PatitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(new PatitionLabels().partitionLabels(s));
    }

    public List<Integer> partitionLabels(String S) {

        //when the character was last seen
        //which will help in detemining the partition length
        int[] map = new int[26];
        for(int i=0 ; i<S.length() ; i++){
            map[S.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList();
        int max = -1;
        int start = 0;
        for(int i=0 ; i<S.length() ; i++){
            max = Math.max(map[S.charAt(i) - 'a'], max);

            if(max == i){
                result.add(max - start + 1);
                max = -1;
                start = i+1;
            }
        }

        return result;
    }

}
