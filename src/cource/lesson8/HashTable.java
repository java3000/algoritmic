package cource.lesson8;

public interface HashTable<K, V> {

    void put(K key, V value);

    V get(K key);

    void remove(K key);

    int size();

    boolean isEmpty();

    void display();

    interface Entry<K, V> {

        K getKey();

        V getValue();

        void setValue(V value);
    }

}
