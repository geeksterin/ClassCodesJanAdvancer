package ownHashMap;

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

    private int hashFunction(K key){
        int hc = key.hashCode();
        return Math.abs(hc)%buckets.length;
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

    private HMnode findWithinBucket(int bi, K key) {
        for (int di = 0; di < buckets[bi].size(); di++) {
            HMnode hmnode = buckets[bi].get(di);
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
            hmnode = new HMnode(key,value);
            buckets[bi].addLast(hmnode);
            this.size++;
        } else {
            hmnode.value = value;
        }

        double lambda = (this.size*1.0)/buckets.length;
        if(lambda>2.0){
            rehash();
        }
    }

    private void rehash(){
        LinkedList<HMnode> [] oba = buckets;
        buckets = new LinkedList[2*buckets.length];
        for(int i=0;i<buckets.length;i++){
            buckets[i] = new LinkedList<>();
        }

        this.size = 0;

        for(int bi = 0;bi<oba.length;bi++){
            for(int di =0;di<oba[bi].size();di++){
                HMnode hmnode = oba[bi].get(di);
                put(hmnode.key,hmnode.value);
            }
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
        for(int di = 0;di<buckets[bi].size();di++){
            HMnode hmnode = buckets[bi].get(di);
            if(hmnode.key.equals(key)){
                buckets[bi].remove(di);
                return;
            }
        }
    }

    public void display() {
        System.out.println("``````````````````````````````````");
        for(int i=0;i<buckets.length;i++){
            System.out.print("B"+i+"- ");
            for(int di = 0;di<buckets[i].size();di++){
                HMnode hmnode = buckets[i].get(di);
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

    public ArrayList<K> keySet(){
        ArrayList<K> keys = new ArrayList<>();
        for(int i=0;i<buckets.length;i++){
            for(int di=0;di<buckets[i].size();di++){
                keys.add(buckets[i].get(di).key);
            }
        }

        return keys;
    }

}