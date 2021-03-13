public class Client {
    public static void main(String[] args){
        MedianPQ  mp = new MedianPQ();
        mp.add(10);
        System.out.println(mp.peek());
        mp.add(100);;
        System.out.println(mp.peek());
        mp.add(90);
        System.out.println(mp.peek());
        mp.add(80);;
        System.out.println(mp.peek());
        mp.add(110);
        System.out.println(mp.peek());
        mp.add(105);;
        System.out.println(mp.peek());
        mp.add(120);
        System.out.println(mp.peek());
        System.out.println();
        System.out.println(mp.remove());
        System.out.println(mp.remove());
        System.out.println(mp.remove());
        System.out.println(mp.remove());
    }
}
