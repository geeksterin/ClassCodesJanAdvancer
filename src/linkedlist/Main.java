package linkedlist;


public class Main {

    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(0);
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addLast(4);
        linkedList.addAtPos(new Node(9), 2);
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.removeAtPos(2);
        //linkedList.addFirst(10);
        System.out.println(linkedList.findMidWithoutSize().getData());
        linkedList.display();
    }
}

//3,2,1,0

//1