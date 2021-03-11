public class client {
    public static void main(String[] args){
        int[] arr = {20,10,5,40,15,75,99,8};
        Heap hp = new Heap(arr,false);
        // hp.add(20);
        // hp.add(10);
        // hp.add(5);
        // hp.add(240);
        // hp.add(15);
        // hp.add(15);
        // hp.add(75);
        // hp.add(99);
        // hp.add(8);
        hp.display();

        System.out.println(hp.remove());
        System.out.println(hp.remove());
        System.out.println(hp.remove());
        System.out.println(hp.remove());
        System.out.println(hp.remove());
    }
}
