package cource.lesson3;

public class MyQueue {

    private int maxSize;
    private int[] array;
    private int start;
    private int end;
    private int count;

    public MyQueue(int s) {
        maxSize = s;
        array = new int[maxSize];
        start = 0;
        end = -1;
        count = 0;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == maxSize);
    }

    public int size() {
        return count;
    }

    public void insert(int i) {
        if (end == maxSize - 1)
            end = -1;
        array[++end] = i;
        count++;
    }

    public long remove() {
        int temp = array[start++];
        if (start == maxSize)
            start = 0;
        count--;
        return temp;
    }

    public int peek() {
        return array[start];
    }
}
