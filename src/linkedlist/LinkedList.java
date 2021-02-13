package linkedlist;

public class LinkedList {

	private Node head;
	private int size;
	private Node tail;

	public void addFirst(int data) {
		Node temp = new Node(data);
		addFirst(temp);
	}

	public void addFirst(Node node) {
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			node.setNext(head);
			this.head = node;
		}
		this.size++;
	}

	public Node addLast(int data) {
		Node temp = new Node(data);
		return this.addLast(temp);
	}

	public Node addLast(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		this.size++;
		return tail;
	}

	public void addAtPos(int data, int pos) throws Exception {
		addAtPos(new Node(data), pos);
	}

	public void addAtPos(Node node, int pos) throws Exception {
		if (pos < 0 || pos > size)
			throw new Exception("position cannot be less than 0 and greater that size");
		if (pos == 0) {
			addFirst(node);
		} else if (pos == size) {
			addLast(node);
		} else {
			int count = 0;
			Node current = head;
			while (count < pos - 1) {
				current = current.getNext();
				count++;
			}
			node.setNext(current.getNext());
			current.setNext(node);
			size++;
		}
	}

	public Node removeFirst() throws Exception {
		Node removedNode = head;
		if (size == 0) {
			throw new Exception("there is no data");
		}
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node temp = head.getNext();
			head.setNext(null);
			head = temp;
		}
		size--;
		return removedNode;
	}

	public Node removeLast() throws Exception {
		Node removedNode = tail;
		if (size == 0) {
			throw new Exception("there is no data");
		}

		if (size == 1) {
			head = null;
			tail = null;
		}
		Node current = head;
		int count = 0;
		while (count < size - 2) {
			current = current.getNext();
			count++;
		}
		tail = current;
		current.setNext(current.getNext().getNext());
		this.size--;
		return removedNode;
	}

	public Node removeAtPos(int pos) throws Exception {
		if (pos < 0 || pos > size - 1) {
			throw new Exception("position cannot be less than 0 and greater that size");
		} else if (pos == 0) {
			removeFirst();
		} else if (pos == size - 1) {
			removeLast();
		} else {
			Node current = head;
			int count = 0;
			while (count < pos - 1) {
				current = current.getNext();
				count++;
			}
			Node temp = current.getNext().getNext();
			current.getNext().setNext(null);
			current.setNext(temp);
			size--;
		}
		return head;
	}

	public Node findMidWithSize() throws Exception {
		if (size == 0) {
			throw new Exception("there is no data");
		}
		int count = 0;
		Node current = head;
		int n = 0;
		if (size % 2 == 0) {
			n = (size / 2) - 1;
		} else {
			n = (size / 2);
		}
		while (count < n) {
			current = current.getNext();
			count++;
		}
		return current;
	}

	public Node findMidWithoutSize() throws Exception {
		if (size == 0) {
			throw new Exception("there is no data");
		}
		Node rabbit = head;
		Node tortoise = head;
		while (rabbit.getNext() != null && rabbit.getNext().getNext() != null) {
			rabbit = rabbit.getNext().getNext();
			tortoise = tortoise.getNext();
		}
		return tortoise;
	}

	public int getFirst() {
		if (this.size == 0) {
			return -1;
		}

		return this.head.getData();
	}

	public int getLast() {
		if (this.size == 0) {
			return -1;
		}

		return this.tail.getData();
	}

	public int getAt(int idx) {
		if (idx >= this.size || idx < 0) {
			return -1;
		}

		int count = 0;
		Node temp = this.head;
		while (count < idx) {
			temp = temp.getNext();
			count++;
		}

		return temp.getData();
	}

	public Node getNodeAt(int idx) throws Exception {
		if (idx >= this.size || idx < 0) {
			throw new Exception("Not Possible Index");
		}

		int count = 0;
		Node temp = this.head;
		while (count < idx) {
			temp = temp.getNext();
			count++;
		}

		return temp;
	}

	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.getData() + "->");
			current = current.getNext();
		}
		System.out.println();
	}

	public void reverseDI() throws Exception {
		int l = 0;
		int r = this.size - 1;
		while (l < r) {
			Node lNode = getNodeAt(l);
			Node rNode = getNodeAt(r);

//			swap
			int temp = lNode.getData();
			lNode.setData(rNode.getData());
			rNode.setData(temp);
			l++;
			r--;
		}
	}

	public void reversePI() {
		Node curr = this.head;
		Node prev = null;
		while (curr != null) {
			Node temp = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = temp;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	private Node leftHelper;

	public boolean isPalindrome() {
		leftHelper = this.head;
		return isPalindrome(this.head);
	}

	private boolean isPalindrome(Node right) {
		if (right == null) {
			return true;
		}
		Boolean bl = isPalindrome(right.getNext());
		if (bl == false) {
			return false;
		}
		if (leftHelper.getData() != right.getData()) {
			return false;
		}

		leftHelper = leftHelper.getNext();
		return true;
	}

	public void fold() {
		leftHelper = this.head;
		fold(this.head, 0);
	}

	private void fold(Node right, int floor) {
		if (right == null) {
			return;
		}
		fold(right.getNext(), floor + 1);
		if (floor > size / 2) {
			Node currLeftNext = leftHelper.getNext();
			leftHelper.setNext(right);
			right.setNext(currLeftNext);
			leftHelper = currLeftNext;
		}

		if (floor == size / 2) {
			right.setNext(null);
			tail = right;
		}
	}

	public void reverseDR() {
		leftHelper = this.head;
		reverseDR(this.head, 0);
	}

	private void reverseDR(Node right, int floor) {
		if (right == null) {
			return;
		}
		reverseDR(right.getNext(), floor + 1);
		if (floor >= size / 2) {
			int temp = leftHelper.getData();
			leftHelper.setData(right.getData());
			right.setData(temp);
			leftHelper = leftHelper.getNext();
		}

	}

	public int kFromLast(int k) {
		Node fast = this.head;
		Node slow = this.head;

		while (k-- > 0) {
			fast = fast.getNext();
		}

		while (fast != null) {
			fast = fast.getNext();
			slow = slow.getNext();
		}

		return slow.getData();
	}

	public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
		LinkedList res = new LinkedList();
		Node temp1 = l1.head;
		Node temp2 = l2.head;
		while (temp1 != null && temp2 != null) {
			int val1 = temp1.getData();
			int val2 = temp2.getData();

			if (val1 < val2) {
				res.addLast(val1);
				temp1 = temp1.getNext();
			} else {
				res.addLast(val2);
				temp2 = temp2.getNext();
			}
		}

		while (temp1 != null) {
			int val1 = temp1.getData();

			res.addLast(val1);
			temp1 = temp1.getNext();
		}

		while (temp2 != null) {
			int val2 = temp2.getData();

			res.addLast(val2);
			temp2 = temp2.getNext();
		}

		return res;
	}

	public void reversePR() {
		reversePR(head);
		Node temp = this.tail;
		this.tail = this.head;
		this.head = temp;
		this.tail.setNext(null);
	}

	private void reversePR(Node node) {
		if (node.getNext() == null) {
			return;
		}
		reversePR(node.getNext());
		node.getNext().setNext(node);
	}
	
//	public static void makeCycle(LinkedList list) {
//		list.tail.setNext(list.head);
//	}

	public static boolean isCycle(LinkedList list) {
		Node slow = list.head;
		Node fast = list.head;

		while (slow != null && fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public void removeDuplicates() {
		if(head == null || head.getNext() == null)
			return;
		Node curr = head;
		while(curr != null && curr.getNext() != null) {
			while(curr.getNext() != null && curr.getData() == curr.getNext().getData()) {
				curr.setNext(curr.getNext().getNext());
			}
			curr = curr.getNext();
		}

	}

//	public void removeCycle() {
//		Node curr = head;
//		boolean isCycle = isCycle(this);
//		if(!isCycle)
//			return;
//		Node slow = head.getNext();
//		Node fast = head.getNext().getNext();
//		while (slow != fast) {
//			slow = slow.getNext();
//			fast = fast.getNext().getNext();
//		}
//		slow = head;
//		Node prev = fast;
//		while (slow != fast) {
//			prev = fast;
//			slow = slow.getNext();
//			fast = fast.getNext();
//		}
//		prev.setNext(null);
//	}
	//1, 2, 3, 4, 5,

	public void reverseInGroup(int k) {
		Node temp = head;
		head = reverseInGroup(head, k);
		tail = temp;
	}

	public Node reverseInGroup(Node tempHead, int k) {
		Node curr = tempHead;
		Node prev = null;
		Node nextOne = null;
		int count = 0;
		//normal reverse code
		while(count < k && curr != null) {
			nextOne =  curr.getNext(); //2
			curr.setNext(prev);
			prev = curr;
			curr = nextOne;
			count++;
		}
		if(nextOne != null)
			//recursive call for next set of nodes
			tempHead.setNext(reverseInGroup(nextOne, k));
		return prev;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
}

//

// {{{}}}  //yes
// {{}}}   //false
// }}{{    //false
//

