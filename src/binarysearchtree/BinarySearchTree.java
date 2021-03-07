import java.util.*;

public class BinarySearchTree {

    Node root;

    public void addViaArray(int arr[]) {
        for (int a : arr) {
            this.root = addNodeUtil(this.root, a);
        }
    }

    public void addNode(int data) {
        addNodeUtil(this.root, data);
    }

    public Node addNodeUtil(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = addNodeUtil(root.left, data);
        } else if (data > root.data) {
            root.right = addNodeUtil(root.right, data);
        }
        return root;
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    class Pair {
        int fst;
        int snd;

        public Pair(int fst, int snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }

    public int diameterLength() {
        Pair pair = diameterLength(this.root);
        return pair.snd;
    }

    private Pair diameterLength(Node root) {

        if (root == null)
            return new Pair(0, 0);

        Pair leftDia = diameterLength(root.left);
        Pair rightDia = diameterLength(root.right);

        int maxHeight = Math.max(leftDia.fst, rightDia.fst) + 1;
        int maxDia = Math.max(Math.max(leftDia.snd, rightDia.snd), leftDia.fst + rightDia.fst + 1);
        return new Pair(maxHeight, maxDia);
    }

    public int max() {
        return max(root);
    }

    private int max(Node node) {
        if (node.right == null) {
            return node.data;
        }
        return max(node.right);
    }

    public int min() {
        return min(root);
    }

    private int min(Node node) {
        if (node.left == null) {
            return node.data;
        }
        return min(node.left);
    }

    public void pir(int lo, int hi) {
        pir(root, lo, hi);
    }

    private void pir(Node node, int lo, int hi) {
        if (node == null) {
            return;
        }
        if (node.data > hi) {
            pir(node.left, lo, hi);
        } else if (node.data >= lo && node.data <= hi) {
            pir(node.left, lo, hi);
            System.out.println(node.data);
            pir(node.right, lo, hi);
        } else {
            pir(node.right, lo, hi);
        }
    }

    private int sum;

    public void replaceWithSumOfLargerNodes() {
        sum = 0;
        replaceWithSumOfLargerNodes(root);
    }

    private void replaceWithSumOfLargerNodes(Node node) {
        if (node == null) {
            return;
        }
        replaceWithSumOfLargerNodes(node.right);

        int temp = node.data;
        node.data = sum;
        sum += temp;

        replaceWithSumOfLargerNodes(node.left);
    }

    public void remove(int data) {
        root = remove(root, data);
    }

    private Node remove(Node node, int data) {
        if (node.data > data) {
            node.left = remove(node.left, data);
        } else if (node.data < data) {
            node.right = remove(node.right, data);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
            }
        }

        return node;
    }

    public int LCA(int d1, int d2) {
        return LCA(root, d1, d2);
    }

    private int LCA(Node node, int d1, int d2) {
        if (d1 > node.data && d2 > node.data) {
            return LCA(node.right, d1, d2);
        } else if (d2 < node.data && d1 < node.data) {
            return LCA(node.left, d1, d2);
        } else {
            return node.data;
        }
    }

    public boolean find(int data) {
        return find(root, data);
    }

    private boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }

        if (data > node.data) {
            return find(node.right, data);
        } else {
            return find(node.left, data);
        }
    }

    public void targetSumPair(int sum) {
        targetSumPair(root, sum);
    }

    private void targetSumPair(Node node, int sum) {
        if (node == null) {
            return;
        }
        if (find(sum - node.data)) {
            if (node.data < (sum - node.data)) {
                System.out.println(node.data + " " + (sum - node.data));
            }
        }
        targetSumPair(node.left, sum);
        targetSumPair(node.right, sum);
    }

}
