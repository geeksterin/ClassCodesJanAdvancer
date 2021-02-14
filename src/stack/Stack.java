package stack;

import java.util.ArrayList;

public class Stack<T> {

    ArrayList<T> arrayList = new ArrayList<T>();
    
    public int size() {
    	return this.arrayList.size();
    }

    public void push(T value) {
        arrayList.add(value);
    }

    public T pop() {
        return arrayList.remove(arrayList.size() - 1);
    }

    public T peek() {
        return arrayList.get(arrayList.size() - 1);
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

 }
