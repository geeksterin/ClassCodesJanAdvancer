package linkedlist;

public class Main {

	public static void main(String[] args) throws Exception {
		LinkedList linkedList = new LinkedList();
		linkedList.addFirst(0);
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(2);
		linkedList.addLast(1);
		linkedList.addLast(0);
//        linkedList.addAtPos(new Node(9), 2);
//        linkedList.display();
//        linkedList.removeFirst();
//        linkedList.display();
//        linkedList.removeLast();
//        linkedList.display();
//        linkedList.removeAtPos(2);
//        linkedList.display();
		// linkedList.addFirst(10);
//        System.out.println(linkedList.findMidWithoutSize().getData());
		linkedList.display();
		linkedList.reverseDI();
		linkedList.display();
		linkedList.reversePI();
		linkedList.display();
		System.out.println(linkedList.isPalindrome());
	}
}

//3,2,1,0

//1