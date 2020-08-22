package SortingAndSeraching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FIlterRestaurents {
    public static void main(String[] args) {
        if('9' > '2'){
            System.out.println("dasda");
        }
        String a = "Leetcode is cool";
        String k = Arrays.stream(a.toLowerCase().split(" ")).sorted((b1,b2) ->{
            return b1.length() - b2.length();
        }).map(i -> i).collect(Collectors.joining(" "));
        System.out.println("adasads");
        int[][] arr = {
                {1, 4, 1, 40, 10},
                {2, 8, 0, 50, 5},
                {3, 8, 1, 30, 4},
                {4, 10, 0, 10, 3},
                {5, 1, 1, 15, 1}
        };
    }

    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result = new ArrayList<>();
        if (restaurants == null) return result;
        int l = 0, r = restaurants.length-1;
        int mid = (l+r) >>1;
        while(l<r){
            int pIndex = partition(restaurants, veganFriendly, maxPrice, maxDistance, l, r);
            System.out.println("PIndex-"+ pIndex);
        }
        return result;
    }

    static int partition(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance, int start, int end){
        int[] pivot = restaurants[end];
        int pIndex = start;
        for(int i=start;i<end;i++){
            if(compare(restaurants[i], pivot, veganFriendly, maxPrice, maxDistance)){
//                swap(restaurants[i], restaurants[pIndex]);
                pIndex++;
            }
        }
        return 0;
    }
    static boolean compare(int[] arr1, int[] arr2, int veganFriendly, int maxPrice, int maxDistance){
        int points1 = 0, points2 = 0;
        if(veganFriendly==1){

        }
        return false;
    }
}
