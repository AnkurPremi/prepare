package DataStructures.stacks;

import java.util.Stack;

//Implement a MyQueue class which implements a queue using two DataStructures.stacks.
public class MyQueueUsingStacks<T> {
    Stack<T> stack1;
    Stack<T> stack2;

    MyQueueUsingStacks(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public static void main(String[] args) {
        MyQueueUsingStacks<String> myQueueUsingStacks = new MyQueueUsingStacks<>();
        myQueueUsingStacks.enQueue("Ankur");
        myQueueUsingStacks.enQueue("Ankur1");
        myQueueUsingStacks.enQueue("Ankur2");
        System.out.println(myQueueUsingStacks.dQueue());
        System.out.println(myQueueUsingStacks.peek());
        System.out.println(myQueueUsingStacks.peek());
    }

    public void enQueue(T t){
        stack1.push(t);
    }

    public T dQueue(){
        Stack<T> t = checkData();
        return t == null ? null : t.pop();
    }

    public T peek(){
        Stack<T> t = checkData();
        return t == null ? null : t.peek();
    }

    private void transferData(Stack<T> stack1, Stack<T> stack2){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    private Stack<T> checkData(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }
        if(stack2.isEmpty()){
            transferData(stack1, stack2);
        }
        return stack2;
    }
}
