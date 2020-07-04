package com.derek;

public class PriorityQueue {

    private Heap heap = new Heap();

    public void enqueue(int data) {
        heap.insert(data);
    }

    public int dequeue() {
        return heap.removeAndReturn();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void print() {
        heap.printHeap();
    }

}
