package homework8;

public interface IHashTable<K, V> {
    boolean put(K key, V value);
    V get(K key);
    V remove(K key);
    int size();
    boolean isEmpty();
    void display();

    interface IEntry<K, V> {
        K getKey();
        V getValue();

        void setValue(V value);
    }
}