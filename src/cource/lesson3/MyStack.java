package cource.lesson3;

public class MyStack<E> {

    private int maxSize;
    private E[] array;
    private int top;

    public MyStack(int size) {
        this.maxSize = size;
        this.array = (E[]) new Object[maxSize];
        this.top = -1;
    }

    public MyStack() {
        this(10);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void push(E s) {
        array[++top] = s;
    }

    public E pop() {
        return array[top--];
    }

    public E peek() {
        return array[top];
    }
}
