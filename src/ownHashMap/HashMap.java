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

    private LinkedList<HMnode>[] buckets;

    private int size = 0;

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
        int bi = hashFunction(key);
        HMnode hmnode = findWithinBucket(bi, key);

        if (hmnode == null) {
            HMnode = new HMnode(key,value);
            buckets[bi].addLast(hmnode);
            this.size++;
        } else {
            hmnode.value = value;
        }
    }

    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        HMnode hmnode = findWithinBucket(bi, key);

        if (hmnode == null) {
            return false;
        } else {
            return true;
        }
    }

    public V remove(K key) {
        int bi = hashFunction(key);
        HMnode hmnode = findWithinBucket(bi, key);

        if (hmnode == null) {
            return null;
        } else {
            removeFromBucket(bi,key);
            this.size--;
            return hmnode.value;
        }
    }

    private void removeFromBucket(int bi, K key){
        for(int di = 0;di<buckets[bi].size;di++){
            HMnode hmnode = buckets[bi].getAt(di);
            if(hmnode.key.equals(key)){
                bucket[bi].removeAt(di);
                return;
            }
        }
    }

    public void display() {
        System.out.println("``````````````````````````````````");
        for(int i=0;i<buckets.length;i++){
            System.out.println("B"+i+"- ");
            for(int di = 0;di<buckets[i].size;di++){
                HMnode hmnode = buckets[i].getAt(di);
                System.out.print("{"+hmnode.key+"="+hmnode.value+"}, ");
            }
            System.out.println();
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}