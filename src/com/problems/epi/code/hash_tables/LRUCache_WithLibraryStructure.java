package com.problems.epi.code.hash_tables;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An alternative solution to the LRU cache problem using LinkedHashMap
 * Note: LinkedHashMap uses a doubly linked list and a hash map under the hood; just like the implementation LRUCache_WithOutLibraryStructure.java
 */
public class LRUCache_WithLibraryStructure {
    int capacity;
    LinkedHashMap<Integer, Double> map = new LinkedHashMap<Integer, Double>(capacity, 1.0f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return map.size() > capacity;
        }
    };

    public double get(int key) {
        if(!map.containsKey(key)) return -1;
        return map.get(key);
    }

    public void put(int k, double v) {
        map.get(k);
        if(!map.containsKey(k))
            map.put(k,v);
    }

    public boolean remove(int key) {
        return map.remove(key) != null;
    }
}
