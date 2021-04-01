package ownHashMap;

public class Client {
    public static void main(String[] args){
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(10, 10);
        hmap.put(100, 1);
        hmap.put(90, 70);
        hmap.put(80, 100);

        hmap.put(1000, 1);
        hmap.put(0, 10);
        hmap.display();
        System.out.println(hmap.get(90));
        hmap.remove(90);
        hmap.put(10, 10000);
        hmap.display();
        hmap.put(99, 10000);
        hmap.put(786, 10000);
        hmap.put(44, 10000);
        hmap.put(30, 10000);
        hmap.display();
        System.out.println(hmap.keySet());
    }
}
