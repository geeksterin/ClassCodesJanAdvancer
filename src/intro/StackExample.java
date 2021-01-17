package intro;

import java.util.Scanner;

public class StackExample {
    private static int idx = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stack = new int[N];

        pushIntoStack(stack, 1);
        pushIntoStack(stack, 2);
        pushIntoStack(stack, 3);  // 1, 2, 3
        peek(stack); // 3
        pop(stack); // 1, 2
        peek(stack); // 2
        pop(stack); // 2
        pushIntoStack(stack, 4); // 1, 4
        pushIntoStack(stack, 5); // 1, 4, 5
        printStack(stack); // 1, 4, 5

    }

    private static void pushIntoStack(int[] stack, int ele) {
        if (!isFull(stack)) {
            idx += 1;
            stack[idx] = ele;
        }
    }

    private static void printStack(int[] stack) {
        System.out.println("Printing full stack --->");
        while (!isEmpty()) {
            peek(stack);
            pop(stack);
        }
    }

    private static void pop(int[] stack) {
        if (!isEmpty()) {
            int poppedElement = stack[idx];
            System.out.println("Stack deleted element is : " + poppedElement);
            idx -= 1;
        }
    }

    private static boolean isFull(int[] stack) {
        if (idx == stack.length - 1) {
            System.out.println("Stack is full");
            return true;
        }
        return false;
    }

    private static boolean isEmpty() {
        if (idx == -1) {
            System.out.println("stack is empty");
            return true;
        }
        return false;
    }

    private static void peek(int[] stack) {
        if (!isEmpty()) {
            int ele = stack[idx];
            System.out.println("Stack peek is : " + ele);
        }
    }
}
