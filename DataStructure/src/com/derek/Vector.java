package com.derek;

// Implementation of dynamic array class

import java.util.Arrays;

public class Vector {
    private int[] array;
    private int arraySize;
    private int dataSize = 0;

    /*
    / Constructors
     */

    public Vector() {
        // Default array size starts from 16
        this.arraySize = 16;
        this.array = new int[arraySize];
    }

    public Vector(int size) {
        this.arraySize = size;
        this.array = new int[size];
    }


    /*
    / Public methods
     */

    // insert a new data at a specific position
    public void insert(int index, int data) {

        // double the Vector if it's full
        if (isFull())
            doubleSize();

        // Exception: index out of range
        if (index > dataSize)
            throw new IllegalStateException();

        // Move items 1 step forward
        if (index != dataSize)
            moveRight(index);

        // Place the item at the specified position
        array[index] = data;
        dataSize++;
    }

    // insert a new data at the end of the array
    public void push(int data) {
        insert(dataSize, data);
    }

    // insert item at index 0
    public void prepend(int data) {
        insert(0, data);
    }


    // looks for value and removes index holding it (even if in multiple places)
    public void remove(int data) {
        for (int i = 0; i < dataSize; i++)
            if (array[i] == data)
                removeAt(i--);
    }


    // delete item at index, shifting all trailing elements left
    public void removeAt(int index) {

        // Exceptional case
        if (index >= dataSize)
            throw new IllegalStateException();

        moveLeft(index);
        dataSize -= 1;
    }

    // remove from end, return value
    public int pop() {
        var tmp = array[dataSize - 1];
        removeAt(dataSize - 1);

        if (dataSize < arraySize / 2)
            halveSize();

        return tmp;
    }


    public int indexOf(int data) {
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == data)
                return i;
        }
        return -1;
    }

    // Return the number of items
    public int size() {
        return dataSize;
    }

    // Return the number of items it can hold
    public int capacity() {
        return arraySize;
    }

    public void print() {
        var tmp = new int[dataSize];
        for (int i = 0; i < dataSize; i++)
            tmp[i] = array[i];
        System.out.println(Arrays.toString(tmp));
    }

    /*
    / Private methods
     */
    private boolean isEmpty() {
        return dataSize == 0;
    }

    private boolean isFull() {
        return dataSize == arraySize;
    }

    private void resize(int newCapacity) {
        int[] tmp = new int[newCapacity];

        if (newCapacity > arraySize) {
            for (int i = 0; i < arraySize; i++)
                tmp[i] = array[i];
        }
        else {
            for (int i = 0; i < newCapacity; i++)
                tmp[i] = array[i];
        }

        array = tmp;
        arraySize = newCapacity;
    }

    private void doubleSize() {
        resize(arraySize * 2);
    }

    private void halveSize() {
        resize(arraySize / 2);
    }

    // Move the left trailing element left by 1 step
    private void moveLeft(int index) {
        for (int i = index; i < dataSize; i++) {
            array[i] = array[i + 1];
        }

        array[dataSize] = 0;
    }

    // Move the trailing element right by 1 step
    private void moveRight(int index) {
        if (index != dataSize)
            for (int i = dataSize; i >= index; i--)
                array[i+1] = array[i];
    }
}
