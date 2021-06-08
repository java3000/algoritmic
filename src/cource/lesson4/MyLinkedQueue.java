package cource.lesson4;

public class MyLinkedQueue<E>{

    private final MyTwoWayLinkedList<E> data;

    public MyLinkedQueue() {
        this.data = new MyTwoWayLinkedList<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public boolean contains(Object o) {
        if (data.isEmpty()) return false;
        return data.find((E) o) != null;
    }

    public boolean add(E e) {
        data.insert(e);
        return true;
    }

    public boolean remove(Object o) {
        return data.delete(o);
    }

    public void clear() {
        data.clear();
    }

    public E remove() {
        return (E) data.delete();
    }

    public E peek() {
        return data.peekFirst();
    }
}
