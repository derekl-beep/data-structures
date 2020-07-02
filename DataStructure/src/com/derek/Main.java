package com.derek;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        HashTable map = new HashTable();

        map.put(1, "Hello");
        map.put(11, "World");
        map.put(1, "Yeah");

        System.out.println(map.get(1));
        System.out.println(map.get(11));

        map.remove(1);
        System.out.println(map.get(1));

    }
}
