package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    public static void main(String[] args) {
        int[][] i1 = {{0,2},
                {5,10},
                {13,23},
                {24,25}};
        int[][] i2 =  {{1,5},
                {8,12},
                {15,24},
                {25,26}};
        System.out.println(new IntervalIntersection().intervalIntersection(i1, i2));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length, n = secondList.length;
        if(m == 0) return firstList;
        if(n == 0) return secondList;

        int i = 0, j = 0;
        List<int[]> list = new ArrayList();

        while(i < m && j < n){

            int start = -1, end = -1;

            if(firstList[i][1] >= secondList[j][0]){
                start = secondList[j][0];
                end = firstList[i][1];
            } else if (firstList[i][0] <= secondList[j][1]){
                start = firstList[i][1];
                end = secondList[j][0];
            }

            if(start != -1){
                list.add(new int[] {start, end});
            }

            if(firstList[i][1] >= secondList[j][1]) j++;
            else if(firstList[i][1] < secondList[j][1]) i++;

        }

        int[][] ans = new int[list.size()][2];
        for(int k = 0 ; k < list.size() ; k++){
            ans[k] = list.get(k);
        }
        return ans;
    }
}
