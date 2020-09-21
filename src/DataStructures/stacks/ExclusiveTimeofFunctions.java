package DataStructures.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
    public static void main(String[] args) {
        int n =2;
        List<String> list = new ArrayList<>(Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
        int[] arr = new ExclusiveTimeofFunctions().exclusiveTime(n, list);
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        StringBuilder stringBuilder = new StringBuilder();

        int[] result = new int[n];
        Stack<Element> stack = new Stack<>();
        for (String s : logs) {
            Element e = parseLog(s);
            if (!stack.isEmpty() && stack.peek().id == e.id) {
                Element pop = stack.pop();
                if (pop.totalTime == 0) {
                    result[pop.id] = e.time - pop.time + 1;
                } else {
                    result[pop.id] = pop.totalTime + 1;
                }
                continue;
            }
            if (!stack.isEmpty()) {
                stack.peek().totalTime = e.time - stack.peek().time;
            }
            stack.push(e);
        }
        return result;
    }

    public Element parseLog(String log) {
        String[] arr = log.split(":");
        return new Element(Integer.parseInt(arr[0]), Integer.parseInt(arr[2]));
    }

    class Element {
        int id;
        int time;
        int totalTime;

        Element(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}
