package homework8;

import java.util.LinkedList;
import java.util.List;

public class ChainHashTable<K, V> implements IHashTable<K, V> {

    private final List<Entry<K, V>>[] data;
    private int size;

    public ChainHashTable(int initialCapacity) {
        this.data = new LinkedList[initialCapacity];
    }

    private int hashFunction(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunction(key);
        if (data[index] == null) data[index] = new LinkedList<>();
        for (Entry<K, V> entry: data[index]) {
            if (isKeysEquals(entry, key)) {
                entry.setValue(value);
                return true;
            }
        }
        data[index].add(new Entry<>(key, value));
        size++;
        return true;
    }

    private boolean isKeysEquals(Entry<K, V> entry, K key) {
        return entry != null &&
                (entry.key == null ? key == null : entry.key.equals(key));
    }

    @Override
    public V get(K key) {
        int index = hashFunction(key);
        for (Entry<K, V> entry: data[index]) {
            if (isKeysEquals(entry, key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunction(key);
        for (Entry<K, V> entry: data[index]) {
            if (isKeysEquals(entry, key)) {
                data[index].remove(entry);
                size--;
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length; i++) {
            sb.append(i).append(" ");
            if (data[i] == null || data[i].isEmpty()) {
                sb.append("null\n");
            } else {
                for (int j = 0; j < data[i].size(); j++) {
                    if (j != 0) sb.append("\t");
                    sb.append(data[i].get(j));
                    if (j != data[i].size() - 1) sb.append(" ->");
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

    static class Entry<K, V> implements IEntry<K, V> {
        private final K key;
        private V value;

        private Entry(K key, V value) {
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
            return "Entry{ key = " + key + ", value = " + value + '}';
        }
    }
}