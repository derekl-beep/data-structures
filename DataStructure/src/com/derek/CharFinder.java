package com.derek;

import java.util.HashMap;
import java.util.HashSet;

public class CharFinder {
    public Character findFirstNonRepeatingChar(String str) {

        // convert String to char[] array
        var chars = str.toCharArray();

        // initialize a hash table
        HashMap<Character, Integer> map = new HashMap<>();

        // store the character counts in the hashtable
        for (char ch : chars) {
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        // print the first non-repeated character
        for (char ch : chars) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }

    public Character findFirstRepeatingChar(String str) {

        // convert String to char[] array
        var chars = str.toCharArray();

        // initialize a set
        HashSet<Character> set = new HashSet<>();

        // Loop over the char[] and return the first repeated character
        for (char ch : chars) {
            if (set.contains(ch)) return ch;
            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
