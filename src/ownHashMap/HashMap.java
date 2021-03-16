import java.util.*;

public class HashMap<K, V> {
    private class HMnode {
        K key;
        V value;

        public HMnode(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private LinkedList<HMNode>[] buckets;

    public HashMap() {
        buckets = new LinkedList[4];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public V get(K key) {
        int bi = hashFunction(key);
        HMnode hmnode = findWithinBucket(bi, key);

        if (hmnode == null) {
            return null;
        } else {
            return hmnode.value;
        }
    }

    private HMNode findWithinBucket(int bi, K key) {
        for (int di = 0; di < buckets[bi].size(); di++) {
            HMnode hmnode = buckets[bi].getAt(di);
            if (hmnode.key.equals(key)) {
                return hmnode;
            }
        }

        return null;
    }

    public void put(K key, V value) {
        
    }

    public boolean containsKey(K key) {

    }

    public V remove(K key) {

    }

    public void display() {

    }

    public int size() {

    }

    public boolean isEmpty() {

    }

}