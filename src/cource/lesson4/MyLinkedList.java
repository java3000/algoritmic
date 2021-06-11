package cource.lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<E> implements Iterable<E> {

    private Node first;
    private Node last;
    private int size;

    private class Node<E> {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return getData().equals(node.getData()) && Objects.equals(getNext(), node.getNext());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getData(), getNext());
        }
    }

    private class MyLinkedListIterator<E> implements Iterator<E> {

        private Node<E> current;
        private int index;

        MyLinkedListIterator(){
            current = last;
            index = size;
        }
        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public E next() {
            E result = null;
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                result = current.getData();
                current = current.getNext();
            }
            index--;
            return result;
        }
    }

    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    public boolean isEmpty() {
        return (first == null && size > 0);
    }

    public int getSize(){
        return size;
    }

    public E peek(){
        return (E) first.getData();
    }

    public void insert(E data) {
        Node node = new Node(data);
        if (first == null) first = node;
        node.next = last;
        last = node;
        size++;
    }

    public Node delete() {
        if (!isEmpty()) {
            Node deleted = first;
            first = first.next;
            size--;
            return deleted;
        }
        return null;
    }

    public E find(E searchNode) {
        Node findNode = new Node(searchNode);
        Node current = first;
        while (current != null) {
            if (current.getData().equals(findNode.getData())) {
                return (E) findNode.getData();
            }
            current = current.getNext();
        }
        return null;
    }
}
