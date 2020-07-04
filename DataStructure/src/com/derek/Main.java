package com.derek;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.enqueue(1);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(4);
        priorityQueue.enqueue(8);
        priorityQueue.enqueue(16);
        priorityQueue.enqueue(32);

        priorityQueue.print();

        System.out.println(priorityQueue.dequeue());
        priorityQueue.print();

    }
}
