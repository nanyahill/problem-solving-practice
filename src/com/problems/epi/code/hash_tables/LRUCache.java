package com.problems.epi.code.hash_tables;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class LRUCache {
    HashMap<Integer, CacheNode> map = new HashMap<>();
    CacheNode head, tail;
    int capacity;

    public LRUCache(int maxSize) { this.capacity = maxSize; }

    public Double get(int key) {
        if(!map.containsKey(key)) return null; //throw new NoSuchElementException();
        CacheNode node = map.get(key);
        removeNodeFromList(node);
        insertNodeInFrontOfList(node);
        return node.value;
    }

    public boolean insert(int key, double value) {
        if(map.containsKey(key)) return false;
        CacheNode node = new CacheNode(key, value);
        if(map.size() >= capacity && tail != null) {
            remove(tail.key);
        }
        insertNodeInFrontOfList(node);
        map.put(key, node);
        return true;
    }

    public CacheNode remove(int key) {
        if(!map.containsKey(key)) throw new NoSuchElementException();
        CacheNode node = map.get(key);
        removeNodeFromList(node);
        map.remove(key);
        return node;
    }

    private void removeNodeFromList(CacheNode node) {
        if(node == null) return;
        if(node == head) { head = node.next; }
        if(node == tail) { tail = node.prev; }
        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;
    }

    private void insertNodeInFrontOfList(CacheNode node) {
        if(node == null) return;
        if(head == null) { head = node; tail = node; }
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    static class CacheNode {
        public int key;
        public double value;
        private CacheNode next; // private because it is only used for internal list maintenance
        private CacheNode prev;

        public CacheNode(int key, double value) { this.key = key; this.value = value; }
    }
}
