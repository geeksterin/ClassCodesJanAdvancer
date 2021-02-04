package linkedlist;

public class LinkedList {

    private Node head;
    private int size;
    private Node tail;

    public void addFirst(int data) {
        addFirst(new Node(data));
    }

    public void addFirst(Node node) {
        if(head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        this.size++;
    }

    public void addLast(int data) {
        addLast(new Node(data));
    }
    public void addLast(Node node) {
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
        }
        this.size++;
    }

    public void addAtPos(int data, int pos) throws Exception{
        addAtPos(new Node(data), pos);
    }

    public void addAtPos(Node node, int pos) throws Exception {
        if (pos < 0 || pos > size)
            throw new Exception("position cannot be less than 0 and greater that size");
        if(pos == 0) {
            addFirst(node);
        } else if(pos == size) {
            addLast(node);
        } else {
            int count =0;
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
        if(size == 0) {
            throw new Exception("there is no data");
        }
        if(size == 1) {
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
        if(size == 0) {
            throw new Exception("there is no data");
        }

        if(size == 1) {
            head = null;
            tail = null;
        }
        Node current = head;
        int count = 0;
        while(count < size - 2) {
            current = current.getNext();
            count++;
        }
        tail = current;
        current.setNext(current.getNext().getNext());
        this.size--;
        return removedNode;
    }

    public Node removeAtPos(int pos) throws Exception {
        if(pos < 0 || pos > size - 1) {
            throw new Exception("position cannot be less than 0 and greater that size");
        } else if(pos == 0) {
            removeFirst();
        } else if(pos == size - 1) {
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
        if(size % 2 == 0) { n = (size/2) - 1; }
        else { n = (size/2); }
        while(count < n) {
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
        while(rabbit.getNext() != null && rabbit.getNext().getNext() != null) {
            rabbit = rabbit.getNext().getNext();
            tortoise = tortoise.getNext();
        }
        return tortoise;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }
}
