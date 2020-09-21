package DataStructures.problemsArray;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 1, 2};
        new DegreeOfAnArray().findShortestSubArray(nums);
    }

    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        Map<Integer, Element> map = new HashMap<Integer, Element>();
        int maxFrequency = 0;
        int diff = 0;
        for (int i = 0; i < len; i++) {
            //Store the element in the map along with the start index when the num was first seen
            //and the last index when the num was last seen and its frequency
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).lastIdx = i;
                map.get(nums[i]).frequency++;
            } else {
                map.put(nums[i], new Element(i));
            }

            Element e = map.get(nums[i]);

            //if we are finding multiple elements with same high frequency
            //then we check..if the diff b/w the first and last index for the current element is smaller than the diff b/w the rest of the max frequency numbers
            if (e.frequency == maxFrequency && e.lastIdx - e.firstIdx < diff) {
                diff = e.lastIdx - e.firstIdx;
            }
            //else check if the element has the highest frequency..
            //if yes.. then update maxFrequency and diff between first and the last index of the element
            else if (e.frequency > maxFrequency) {
                maxFrequency = e.frequency;
                diff = e.lastIdx - e.firstIdx;
            }
        }
        return diff + 1;
    }
}

class Element {
    int firstIdx = -1;
    int lastIdx = -1;
    int frequency = 0;

    public Element(int i) {
        firstIdx = i;
        lastIdx = i;
        frequency = 1;
    }
}
