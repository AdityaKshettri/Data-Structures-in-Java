package com.aditya.project.ds.stack;

import java.util.ArrayList;
import java.util.List;

public class ListStack<X> {

    private final List<X> data;
    private int stackPointer;

    public ListStack() {
        data = new ArrayList<>();
        stackPointer = 0;
    }

    public void push(X newItem) {
        data.add(newItem);
        stackPointer++;
    }

    public X pop() {
        if (stackPointer == 0) {
            throw new IllegalStateException("No more items on stack!");
        }
        return data.remove(--stackPointer);
    }

    public int size() {
        return stackPointer;
    }

    public boolean contains(X item) {
        for (int i = 0; i < stackPointer; i++) {
            if (data.get(i).equals(item)) {
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
