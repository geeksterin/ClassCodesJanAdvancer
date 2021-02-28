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
}
