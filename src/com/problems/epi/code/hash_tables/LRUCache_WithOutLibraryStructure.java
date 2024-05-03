package com.problems.epi.code.hash_tables;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LRUCache_WithOutLibraryStructure {
        static class CacheNode {
            Integer key;
            Integer value;
            CacheNode prev;
            CacheNode next;

            public CacheNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

        }
        Map<Integer, CacheNode> map;
        int size;
        int capacity;
        CacheNode head;
        CacheNode tail;
    public LRUCache_WithOutLibraryStructure(final int capacity) {
            this.map = new HashMap<>(capacity);
            size = 0;
            this.capacity = capacity;
            head = new CacheNode(0, 0);
            tail = new CacheNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        public Integer get(Integer key) {
            if(!map.containsKey(key)) {
                return -1;
            }
            CacheNode node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.value;
        }
        public void insert(Integer key, Integer value) {
            if(map.containsKey(key)) {
                CacheNode node = map.get(key);
                removeNode(node);
                addNode(node);
                return;
            }
            CacheNode node = new CacheNode(key, value);
            map.put(key, node);
            addNode(node);
            if(map.size() > capacity) {
                CacheNode nodeToDelete = head.next;
                removeNode(nodeToDelete);
                map.remove(nodeToDelete.key);
            }
        }
        public Boolean erase(Object key) {
            removeNode(map.get(key));
            return map.remove(key) != null;
        }

        private Integer removeNode(CacheNode node) {
            if(node == null || node.next == null) return null;
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
            return node.key;
        }

        private void addNode(CacheNode node) {
            CacheNode currTail = tail.prev;
            tail.prev = node;
            node.prev = currTail;
            node.next = tail;
            currTail.next = node;
            size++;
        }
}
