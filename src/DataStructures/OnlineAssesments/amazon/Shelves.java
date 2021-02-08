package DataStructures.OnlineAssesments.amazon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Shelves {
    public static void main(String[] args) throws FileNotFoundException {
        int n = 5, m = 4;
        int[] h = {3, 1};
        int[] v = {1};
        System.out.println(new Shelves().findMaxVolume(n, m, h, v));
    }

    private int getMax(int dim, Set<Integer> set){
        int maxHere = 0, maxTotal = 0;
        for(int i = 0 ; i < dim ; i++){
            maxHere++;
            maxTotal = Math.max(maxTotal, maxHere);
            if(set.contains(i + 1)) {
                maxHere = 0;
            }
        }
        return maxTotal;
    }
    private int findMaxVolume(int n, int m, int[] h, int[] v){
        Set<Integer> widthSet = new HashSet<>();
        Set<Integer> heightSet = new HashSet<>();
        for(int num : h) heightSet.add(num);
        for(int num : v) widthSet.add(num);

        int maxWidth = getMax(n, heightSet), maxHeight = getMax(m, widthSet);
        return maxHeight * maxWidth;
    }
}
