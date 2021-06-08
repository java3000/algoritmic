package cource.lesson4;

import java.util.Objects;

public class MyTwoWayLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    class Node<E> {
        E data;
        Node<E> next;

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

    public boolean isEmpty() {
        return (first == null);
    }

    public int getSize(){
        return size;
    }

    public E peekFirst(){
        return (E) first.getData();
    }

    public E peekLast(){
        return (E) last.getData();
    }

    public void insert(E data) {
        Node node = new Node(data);
        if (this.isEmpty()) last = node;
        node.next = first;
        first = node;
        size++;
    }

    public Node delete() {
        Node temp = first;
        if (first.next == null) last = null;
        first = first.next;
        size--;
        return temp;
    }

    public boolean delete(Object o) {
        Node<E> current = first;
        Node<E> previous = null;
        while (current != null) {
            if (current.data.equals(o)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == first) {
            delete();
            return true;
        } else if (current == last) {
            last = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    public void clear(){
        first = null;
        last = null;
        size = 0;
    }



    public void insertLast(E data) {
        Node node = new Node(data);
        if (this.isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
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
