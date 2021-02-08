package DataStructures.NewWork.LCArray;

import java.util.Collections;
import java.util.LinkedList;

public class FruitsInBasket {
    public static void main(String[] args) {
        int[] arr = {1,0,1,4,1,4,1,2,3};
        System.out.println(new FruitsInBasket().totalFruit(arr));
    }

    public int totalFruit(int[] tree) {
        int start = 0, end = 0;
        int type1 = -1, type2 = -1;
        int type1Count = 0, type2Count = 0;
        int max = 0;

        while (end < tree.length) {
            if (type1 == -1 || type1 == tree[end]) {
                type1Count++;
                type1 = tree[end];
            } else if (type2 == -1 || type2 == tree[end]) {
                type2Count++;
                type2 = tree[end];
            } else {
                max = Math.max(type1Count + type2Count, max);
                while (type1Count != 0 && type2Count != 0) {
                    if (type1 == tree[start]) {
                        type1Count--;
                    } else if(type2 == tree[start]){
                        type2Count--;
                    }
                    start++;
                }

                if(type1Count == 0){
                    type1 = type2;
                    type1Count = type2Count;
                }
                type2 = tree[end];
                type2Count = 1;
            }
            end++;
        }

        return Math.max(type1Count + type2Count, max);
    }
}
