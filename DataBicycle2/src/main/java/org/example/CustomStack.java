package org.example;
import java.util.LinkedList;
public class CustomStack<T> {

    private LinkedList<T> stack;
    public CustomStack(){
        stack = new LinkedList<>();
    }

    public void push(T item) {
        stack.push(item);

    }
    public T pop() {
        return stack.pop();
    }
    public boolean isEmpty(){
        return stack.isEmpty();

    }
}
