package com.aditya.project.ds.stack;

public class ArrayStack<X> {

    private final X[] data;
    private int stackPointer;

    public ArrayStack() {
        this(1000);
    }

    public ArrayStack(int size) {
        data = (X[]) new Object[size];
        stackPointer = 0;
    }

    public void push(X newItem) {
        data[stackPointer++] = newItem;
    }

    public X pop() {
        if (stackPointer == 0) {
            throw new IllegalStateException("No more items on stack!");
        }
        return data[--stackPointer];
    }

    public int size() {
        return stackPointer;
    }

    public boolean contains(X item) {
        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public X access(X item) {
        while (stackPointer > 0) {
            X tmpItem = pop();
            if (item.equals(tmpItem)) {
                return tmpItem;
            }
        }
        throw new IllegalArgumentException("Could not find item on stack : " + item);
    }
}
