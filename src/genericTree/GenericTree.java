package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTree {
    private class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private Node root;
    private int size;

    public GenericTree(int[] arr) {
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                stack.pop();
            } else {
                Node node = new Node();
                node.data = arr[i];
                this.size++;

                if (stack.size() > 0) {
                    stack.peek().children.add(node);
                } else {
                    root = node;
                }

                stack.push(node);
            }
        }
    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        String s = node.data + "-> ";
        for (Node child : node.children) {
            s += child.data + ", ";
        }
        s += ".";
        System.out.println(s);
        for (Node child : node.children) {
            display(child);
        }
    }

    public int size() {
        if (root == null) {
            return 0;
        }
        return size(root);
    }

    private int size(Node node) {
        int size = 0;
        for (Node child : node.children) {
            int csize = size(child);
            size += csize;
        }

        size++;
        return size;
    }

    public int max() {
        return max(root);
    }

    private int max(Node node) {
        int max = node.data;

        for (Node child : node.children) {
            int cmax = max(child);
            max = Math.max(max, cmax);
        }

        return max;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        int ht = 0;
        for (Node child : node.children) {
            int cht = height(child);
            ht = Math.max(ht, cht);
        }

        ht++;
        return ht;
    }

    public boolean find(int data) {
        return find(root, data);
    }

    private boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }

        for (Node child : node.children) {
            boolean childres = find(child, data);
            if (childres == true) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> nodetoRootPath(int data) {
        return nodetoRootPath(root, data);
    }

    private ArrayList<Integer> nodetoRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }
        ArrayList<Integer> mres = new ArrayList<>();
        for (Node child : node.children) {
            ArrayList<Integer> rres = nodetoRootPath(child, data);
            if (rres.size() > 0) {
                mres = rres;
                mres.add(node.data);
                return mres;
            }
        }

        return new ArrayList<>();
    }

    public void removeLeaves() {
        removeLeaves(root);
    }

    private void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() > 0) {
                removeLeaves(child);
            } else {
                node.children.remove(child);
            }
        }
    }

    public void mirror() {
        mirror(root);
    }

    private void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }

        int l = 0;
        int r = node.children.size() - 1;
        while (l < r) {
            Node leftNode = node.children.get(l);
            Node rightNode = node.children.get(r);
            node.children.set(l, rightNode);
            node.children.set(r, leftNode);
            l++;
            r--;
        }
    }

    public void linearise() {
        linearise(root);
    }

    private void linearise(Node node) {
        for (Node child : node.children) {
            linearise(child);
        }

        for (int i = node.children.size() - 1; i > 0; i--) {
            Node last = node.children.remove(i);
            Node slast = node.children.get(i - 1);
            Node sltail = getTail(slast);
            sltail.children.add(last);
        }
    }

    private Node getTail(Node node) {
        Node tail = node;
        while (tail.children.size() != 0) {
            tail = tail.children.get(0);
        }

        return tail;
    }

    public void linearise2() {
        linearise2(root);
    }

    private Node linearise2(Node node) {

        if(node.children.size()==0){
            return node;
        }

        Node ltail = linearise2(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node sltail = linearise2(sl);
            sltail.children.add(last);
        }

        return ltail;
    }

}
