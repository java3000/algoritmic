package cource.lesson8;

import java.util.LinkedList;

public class MyHashTable<K, V> implements HashTable<K, V>{

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final LinkedList<Item<K, V>>[] data;
    private final int size;

    public MyHashTable(int size) {
        this.size = size;
        this.data = new LinkedList[size];
    }

    @Override
    public void put(K key, V value) {
        int index = hashFunc(key);
        if (data[index] == null) {
            data[index] = new LinkedList<>();
        }
        data[index].add(new Item<>(key, value));
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        for (Item<K, V> item : data[index]) {
            if (item.getKey().equals(key))
                return item.getValue();
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int index = hashFunc(key);
        if (!(data[index] == null)) {
            data[index].removeIf(item -> item.getKey().equals(key));
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0 && data.length == 0);
    }

    @Override
    public void display() {
        for (var i : data){
            if (i != null) {
                for (Item<K, V> kvItem : i) {
                    if(kvItem != null) System.out.println(kvItem);
                }
            }
        }
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }
}
