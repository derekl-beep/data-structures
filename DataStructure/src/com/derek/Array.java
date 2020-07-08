package com.derek;

// Implementation of dynamic array class

import java.util.Enumeration;

public class Array {
    private int[] array;
    private int size;
    private int dataSize = 0;


    // Constructor
    public Array(int size) {
        this.size = size;
        this.array = new int[size];
    }

    // Public methods, incl.
    // insert(int data)
    // removeAt(int index)
    // indexOf(int data)

    public void insert(int data) {

        // double the array if it's full
        if (isFull())
            doubleSize();

        array[dataSize] = data;
        dataSize += 1;
    }

    public void removeAt(int index) {

        // Exceptional case
        if (index >= dataSize)
            throw new IllegalStateException();

        for (int i = index; i < dataSize; i++) {
            array[i] = array[i + 1];
            array[i + 1] = 0;
        }
        dataSize -= 1;
    }

    public int indexOf(int data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == data)
                return i;
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < dataSize; i++)
            System.out.println(array[i]);
    }

    // Private methods

    private boolean isFull() {
        return dataSize == size;
    }

    private void doubleSize() {
        int[] tmp = new int[size * 2];
        for (int i = 0; i < size; i++ ) {
            tmp[i] = array[i];
        }
        array = tmp;
        size *= 2;
    }


}
