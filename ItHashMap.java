package Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ItHashMap<K, V> implements ItMap<K, V>{

    private int size = 0;
    private int capacity = 20;
    private List<List<Node<K, V>>> buckets = new LinkedList<>();

    public ItHashMap(){
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash % capacity);
        List<Node<K, V>> bucket = buckets.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                return bucket.get(i).value;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = Math.abs(hash % capacity);
        List<Node<K, V>> bucket = buckets.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                bucket.get(i).value = value;
                return;
            }
        }
        bucket.add(new Node<>(key, value));
        size++;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new ItHashMapIterator();
    }

    private class ItHashMapIterator implements Iterator<Node<K, V>> {
        private int bucketInd = 0;
        private Iterator<Node<K, V>> currentIter = null;

        public boolean hasNext() {
            if (currentIter != null && currentIter.hasNext()) {
                return true;
            }

            for (int i = bucketInd; i < buckets.size(); i++) {
                if (!buckets.get(i).isEmpty()) {
                    currentIter = buckets.get(i).iterator();
                    bucketInd = i + 1;
                    return true;
                }
            }
            return false;
        }

        @Override
        public Node<K, V> next() {
            if (hasNext()) {
                return currentIter.next();
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}