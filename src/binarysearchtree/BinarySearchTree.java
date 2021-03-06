package binarysearchtree;

import com.sun.tools.javac.util.Pair;

public class BinarySearchTree {

    Node root;

    public void addViaArray(int arr[]) {
        for(int a : arr) {
            this.root = addNodeUtil(this.root, a);
        }
    }
    public void addNode(int data) {
        addNodeUtil(this.root, data);
    }
    public Node addNodeUtil(Node root,int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        if(data < root.data) {
            root.left = addNodeUtil(root.left, data);
        } else if(data > root.data) {
            root.right = addNodeUtil(root.right, data);
        }
        return root;
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node root) {
        if(root == null)
            return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public int diameterLength() {
        Pair<Integer, Integer> pair = diameterLength(this.root);
        return pair.snd;
    }

    private Pair<Integer, Integer> diameterLength(Node root) {

        if(root == null)
            return new Pair<>(0, 0);

        Pair<Integer, Integer> leftDia = diameterLength(root.left);
        Pair<Integer, Integer> rightDia = diameterLength(root.right);

        int maxHeight = Math.max(leftDia.fst, rightDia.fst) + 1;
        int maxDia = Math.max(Math.max(leftDia.snd, rightDia.snd), leftDia.fst + rightDia.fst + 1);
        return new Pair<>(maxHeight, maxDia);
    }
}
