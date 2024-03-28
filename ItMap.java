package Collections;

public interface ItMap<K, V> extends Iterable<Node<K, V>> {

    int size();
    V get(K key);
    void put(K key, V value);

}