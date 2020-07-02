package com.derek;

import java.util.NoSuchElementException;

public class LinkedList {
    // private node class included in the LinkedList class
    private class Node {
        private int value;
        private Node next;

        // public constructor of Node
        public Node(int value){
            this.value = value;
        }

        public Node() {
        }
    }

    // head and tail pointers
    private Node first;
    private Node last;

    // size of the linked list
    private int size = 0;

    // Methods:
    // addFirst;
    // addLast;
    // deleteFirst;
    // deleteLast;
    // contains;
    // indexOf;

    public void printList() {
        var cur = new Node();
        cur = first;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }

        // increase the size of the list by 1
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }

        // increase the size of the list by 1
        size++;
    }

    public int indexOf(int item){
        int index = 0;
        var cur = first;

        while (cur != null) {
            if (cur.value == item) return index;
            index += 1;
            cur = cur.next;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;

        // decrease the size of the list by 1
        size--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }

        var previous = getPrevious(last);
        last = previous;
        last.next = null;

        // decrease the size of the list by 1
        size--;
    }

    public int size() {
        return size;

    }

    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;
        Node current = first;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        // Base case 1: empty list
        if (isEmpty()) return;

        // Base case 2: single element
        if (first == last) return;



        // Normal case: with two or more element
        var previous = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {

        // Exceptional case: empty list
        if (isEmpty()) throw new IllegalStateException();

        // Exceptional case: out of range (if the size of the list is known)
        if (k > size) throw new IllegalArgumentException();

        // Base case: the last element:
        if (k == 1) return last.value;

        var current = first;
        var ahead = first;

        // Advance ahead ptr by k-1 steps
        for (int i = 0; i < k - 1; i++) {
            ahead = ahead.next;
            // Exceptional case: out of range (if the size of the list is not known)
            if (ahead == null) throw new IllegalArgumentException();
        }

        // Loop and find the k-th element from the end with the two points separated by k-1 slots
        // until the ahead ptr reaches the end of the list
        // then the current ptr reaches the k-th element from the end
        while (ahead != last) {
            ahead = ahead.next;
            current = current.next;
        }

        return current.value;
    }

    public void printMiddle() {

        // Exceptional case: empty list
        if (isEmpty()) throw new IllegalStateException();

        var slow = first;
        var fast = first;

        // Advance the two ptr til the fast ptr has reached
        // the end of the last or the second last node.
        while (fast != last && fast.next != last) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == last) System.out.println(slow.value);
        else System.out.println(slow.value + ", " + slow.next.value);
    }

    private boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        var cur = first;
        while (cur != null) {
            if (cur.next == node) return cur;
            cur = cur.next;
        }
        return null;
    }
}
