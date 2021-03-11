public class client {
    public static void main(String[] args){
        Heap hp = new Heap();
        hp.add(50);
        hp.add(40);
        hp.add(10);
        hp.add(200);
        hp.add(100);
        hp.display();

        System.out.println(hp.remove());
        System.out.println(hp.remove());
        System.out.println(hp.remove());
        System.out.println(hp.remove());
        System.out.println(hp.remove());
    }
}
