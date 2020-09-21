package DataStructures.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
//        Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
//        threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be
//        composed of several DataStructures.stacks and should create a new stack once the previous one exceeds capacity.
//        SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
//        (that is, pop () should return the same values as it would if there were just a single stack).
//        FOLLOW UP
//        Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack.
public class StackOfPlates {

    static Map<Integer, Stack<String>> map;
    static int stackNumber = 1;
    static int maxSizePerStack = 4;
    static int currentSize = 0;

    public static void main(String[] args) {
        //we are creating a hashmap
        //which will store key as stackNumber
        //and value as corresponding Stack
        map = new HashMap<>();

        push("A1");push("B1");push("c1");push("D1");
        System.out.println(pop());
        push("A2");push("B2");push("c2");push("D2");
        System.out.println(pop());System.out.println(pop());
        push("A3");push("B3");push("c3");push("D3");
        System.out.println(popAt(3));System.out.println(popAt(2));
        push("A4");push("B4");push("c4");push("D4");
        System.out.println("Check the data");
    }

    private static void push(String input) {
        if (currentSize < maxSizePerStack) {
            currentSize++;
        } else {
            stackNumber++;
            currentSize = 1;
        }
        map.put(stackNumber, map.getOrDefault(stackNumber, new Stack<String>()));
        map.get(stackNumber).push(input);
    }

    private static String pop() {
        Stack<String> a = map.get(stackNumber);
        if(a == null){
            return null;
        }
        else{
            String val = a.pop();
            //This question has issues
            //Doesn't completely explains if after popAt, there will be some space left in the stack which needs to be filled.
            currentSize --;
            return val;
        }
    }


    private static String popAt(int val) {
        if(val < 1 || val > stackNumber) return null;
        if(val == stackNumber){
            currentSize--;
        }
        return map.get(val).pop();
    }

}
