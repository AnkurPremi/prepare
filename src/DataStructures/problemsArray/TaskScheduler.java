package DataStructures.problemsArray;

//https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {
    public static void main(String[] args) {
        char[] arr = {'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'C', 'C', 'C', 'C', 'D', 'D', 'D', 'D', 'E', 'F', 'G'};
        int n = 3;
        System.out.println(new TaskScheduler().leastInterval1(arr, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (n == 0 || len == 0) return len;
        int result = 0;
        int[] map = new int[26];
        int maxCount = 0;
        int maxChar = -1;
        for (char c : tasks) {
            map[c - 'A']++;
            if (map[c - 'A'] > maxCount) {
                maxCount = map[c - 'A'];
                maxChar = c - 'A';
            }
        }
        Character[] list = new Character[n * len];
        int i = 0;
        while (map[maxChar] > 0) {
            list[i] = (char) (maxChar + 'A');
            map[maxChar]--;
            if (map[maxChar] < 1) break;
            i += (n + 1);
        }
        System.out.println("asa");
        int j = 1, q = 1;
        for (int k = 0; k < map.length; k++) {
            while (map[k]-- > 0) {
                if (j > i) {
                    j = q + 1;
                    q = q + 1;
                    list[j] = (char) (k + 'A');
                } else {
                    list[j] = (char) (k + 'A');
                }
                j += (n + 1);
            }
        }
        return result;
    }


    //Here we will are not asked to arrange the sequence.. so we will just formulate the number of least interval
    //required to complete the given tasks with the given condition
    //we are basically required to take the tasks from the lists and arrange them in such a way that they are at least (n+1) distance apart
    public int leastInterval1(char[] tasks, int n) {

        //we will first calculate the maximum frequency of an element in the tasks
        //that will decide the complete frame
        //we can have multiple elements in the input array with the maximum frequency
        //eg: A,A,B,B,C,D ... here A and B have the same frequency

        int maxHere = 0;  //this is the max frequency of an element.. or multiple max frequency elements if exists
        int maxCount = 0; //this the number of element having this max frequency
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
            if (maxHere == map[c - 'A']) {
                maxCount++;
            } else if (maxHere < map[c - 'A']) {
                maxHere = map[c - 'A'];
                maxCount = 1;
            }
        }


        //number of slots in the result frame
        int partsCnt = maxHere - 1;

        //find the length of each part
        //maxCount-1 represents.. out of n empty positions in the part.. multiple frequency elements will occupy
        //one position in each part..excluding the first max frequency element which is already arranged (that's why '-1')
        int partLength = n - (maxCount - 1);

        //empty slots: total parts * partLength.... this is the empty positions remained to arrange the elements
        //left after arranging the max req elements
        int emptySlots = partsCnt * partLength;

        //tasks left after arranging the max frequency elements
        int totalAvailableTasks = tasks.length - maxHere * maxCount;

        //number of idles required after arranging all the elements in the frame
        int idles = Math.max(0, emptySlots - totalAvailableTasks);

        //my total min time required to arrange the elements.. will be at least the length of tasks..
        //in which case we will just have to rearrange the elements w/o any extra idles
        return tasks.length + idles;
    }
}
