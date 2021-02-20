package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {


    public static void preOrder(Node root) {

        if(root == null)
            return;

        //start is from middle
        System.out.print(root.data + " ");
        //left is second
        preOrder(root.left);
        //right is third
        preOrder(root.right);

    }

    public static void inOrder(Node root) {

        if(root == null) {
            return;
        }
        //start from left
        inOrder(root.left);
        //middle is second
        System.out.print(root.data + " ");
        //right is third
        inOrder(root.right);
    }

    public static void postOrder(Node root) {

        if(root == null) {
            return;
        }

        //start from left
        postOrder(root.left);

        //right is second
        postOrder(root.right);

        //middle is last
        System.out.print(root.data + " ");
    }

    public static int findHeight(Node root) {

        if(root == null)
            return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public static int findLeft(Node root , int number) {

        if(root == null || root.left == null)
            return -1;
        if(root.data == number)
            return root.left.data;

        int fromLeft = findLeft(root.left, number);
        int fromRight = findLeft(root.right, number);

        return fromLeft != -1 ? fromLeft : fromRight;
    }

    public static Node find(int number, Node root) {
        if(root == null)
            return null;
        if(root.data == number)
            return root;

        Node fromLeft = find(number,root.left);
        Node fromRight = find(number, root.right);

        return fromLeft != null ? fromLeft : fromRight;
    }

    public static void add(Node newNode, int atWhichToAdd ,Node root, Character position) {

        if(root == null) {
            root = newNode;
            return;
        }
        Node current = find(atWhichToAdd, root);
        if(position == 'L' && current.left == null) {
            current.left = newNode;
            return;
        } else if(position == 'R' && current.right == null) {
            current.right = newNode;
            return;
        }
        throw new RuntimeException("already node present");

    }

    public static void levelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currSize = 0;
            Node curr = queue.poll();
            if(curr == null) {
                System.out.println();
                if(queue.size() != 0)
                    queue.add(null);
                continue;
            }
            System.out.print(curr.data + " ");
            if(curr.left != null) {
                queue.add(curr.left);
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
}
