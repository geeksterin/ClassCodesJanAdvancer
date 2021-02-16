package stack;

import java.util.ArrayList;

public class Stack<T extends Comparable> {

    ArrayList<T> arrayList = new ArrayList<T>();
    
    public int size() {
    	return this.arrayList.size();
    }

    ArrayList<T> maxStack = new ArrayList<T>();

    public void push(T value) {
        arrayList.add(value);
        if(maxStack.isEmpty()) {
            maxStack.add(value);
        } else if(value.compareTo(maxStack.get(maxStack.size()-1))  > 0) {
            maxStack.add(value);
        } else {
            maxStack.add(maxStack.get(maxStack.size()-1));
        }
    }

    public T pop() {
        if(!maxStack.isEmpty())
            maxStack.remove(maxStack.size()-1);
        return arrayList.remove(arrayList.size() - 1);
    }

    public T peek() {
        return arrayList.get(arrayList.size() - 1);
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public T getMax() {
        return maxStack.get(maxStack.size()-1);
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }

 }

 //5,1,2,3