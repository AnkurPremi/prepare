package stacks;

import java.util.Stack;

//Write a program to sort a stack such that the smallest items are on the top. You can use
//        an additional temporary stack, but you may not copy the elements into any other data structure
//        (such as an array). The stack supports the following operations: push, pop, peek, and is Empty
public class SortStack {
    static Stack<Integer> mainStack;
    Stack<Integer> tempStack;

    SortStack(){

    }
    public static void main(String[] args) {
        mainStack = new Stack<>();
        mainStack.push(3);
        mainStack.push(5);
        mainStack.push(1);
        mainStack.push(7);
        mainStack.push(2);
        new SortStack().sort(mainStack);
    }

    private void sort(Stack<Integer> stack){
        tempStack = new Stack<>();

        while(!stack.isEmpty()){
            int a = stack.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > a){
                stack.push(tempStack.pop());
            }
            tempStack.push(a);
        }
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        System.out.println("MainStack sorted");
    }
}

