package cource.lesson3;

public class MyDeque {

    private int maxSize;
    private int[] array;
    //r
    private int start;
    //l
    private int end;
    private int count;

    public MyDeque(int s) {
        maxSize = s;
        array = new int[maxSize];
        start = 0;
        end = -1;
        count = 0;
    }

    public void insertLeft(int i){
        if (end == maxSize - 1)
            end = -1;
        array[++end] = i;
        count++;
    }

    //*
    public void insertRight(int i){
        if(i > end || i < start) return;
        int tmp = array[start];
        array[start] = i;
        array[++start] = tmp;
        count++;
    }

    //*
    public int removeLeft(){
        int temp = array[end--];
        if (end == maxSize)
            end = -1;
        count--;
        return temp;
    }
    public int removeRight(){
        int temp = array[start++];
        if (start == maxSize)
            start = 0;
        count--;
        return temp;
    }
}
