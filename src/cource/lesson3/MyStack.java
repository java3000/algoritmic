package cource.lesson3;

public class MyStack {

    private int maxSize;
    private char[] array;
    private int top;

    public MyStack(int size) {
        this.maxSize = size;
        this.array = new char[maxSize];
        this.top = -1;
    }



    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void push(char s) {
        array[++top] = s;
    }

    public char pop() {
        return array[top--];
    }

    public char peek() {
        return array[top];
    }
}
