package com.derek;

import javax.swing.text.html.parser.Entity;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTable {

    private class Entry {
        private int key;
        private String value;

        // Constructor
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] map = new LinkedList[10];

    public void put(int key, String value) {
        // Check if the key already exists
        // If exists, update the value only
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        // If the key is new, add the new key-value into the end of the chain
        getOrCreateBucket(key).addLast(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private int hash(int key) {
        return key % map.length;
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);

        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private LinkedList<Entry> getBucket (int key) {
        return map[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket (int key) {
        int index = hash(key);
        if (map[index] == null)
            map[index] = new LinkedList<>();
        return map[index];
    }

}
