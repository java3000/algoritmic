package cource.lesson4;

import java.util.Stack;

public class MyLinkedStack<E> extends Stack<E> {

    private final MyLinkedList<E> data;

    public MyLinkedStack() {
        this.data = new MyLinkedList<>();
    }

    @Override
    public E push(E item) {
        data.insert(item);
        return item;
    }

    @Override
    public synchronized E pop() {
        return (E) data.delete();
    }

    @Override
    public synchronized E peek() {
        return data.peek();
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean empty() {
        return data.isEmpty();
    }
}
