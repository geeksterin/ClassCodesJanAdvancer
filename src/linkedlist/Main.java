package linkedlist;

public class Main {

	public static void main(String[] args) throws Exception {
		LinkedList linkedList = new LinkedList();
		linkedList.addFirst(0);
		linkedList.addLast(5);
		linkedList.addLast(15);
		linkedList.addLast(35);
		linkedList.addLast(45);
//		linkedList.addLast(5);
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
//		linkedList.display();
//		linkedList.reverseDI();
//		linkedList.display();
//		linkedList.reversePI();
//		linkedList.display();
//		linkedList.display();
//		linkedList.reverseDR();
//		linkedList.display();
//		System.out.println(linkedList.kFromLast(3));
		LinkedList ll = new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		ll.addLast(60);
//		LinkedList.mergeTwoSortedLists(linkedList, ll).display();;
		ll.display();
//		ll.reversePR();
//		ll.display();
//		LinkedList.makeCycle(ll);
		System.out.println(LinkedList.isCycle(ll));
//		System.out.println(linkedList.isPalindrome());
	}
}

//3,2,1,0

//1