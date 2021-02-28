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
}
