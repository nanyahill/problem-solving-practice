package com.problems.epi.code.hash_tables.implementation;

public class MyHashTable {

    int size = 0;
    int initialCapacity;
    final int DEFAULT_CAPACITY = 10;
    Bucket[] buckets = new Bucket[DEFAULT_CAPACITY];

    public MyHashTable(int capacity) {
        this.initialCapacity = capacity;
        buckets = new Bucket[initialCapacity];
    }

    private int hash(int key) {
        return Integer.hashCode(key) % buckets.length; // keeps hash code in range 0 to buckets.length - 1.
    }

    public int get(int key) {
        int idx = hash(key);
        if (buckets[idx] == null) return -1; // nothing is in this bucket.
        BucketNode node = findKey(key, buckets[idx]);
        return node.next == null ? -1 : node.next.value; // still check for null because a sequence of operations could make a bucket 'empty'
    }

    public void put(int key, int value) {
        int idx = hash(key);
        if (buckets[idx] == null) buckets[idx] = new Bucket();
        BucketNode node = findKey(key, buckets[idx]);
        if (node.next == null) {
            node.next = new BucketNode(key, value);
            size++;
            return;
        }
        node.next.value = value;
        size++;
    }

    public void remove(int key) {
        int idx = hash(key);
        if (buckets[idx] == null) return; // nothing is in this bucket to remove.
        BucketNode node = findKey(key, buckets[idx]);
        if (node.next == null) return;
        node.next = node.next.next;
        size--;
    }

    private BucketNode findKey(int key, Bucket node) {
        BucketNode prev = null;
        BucketNode curr = node.head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    private static class Bucket {
        BucketNode head = new BucketNode(-1, -1);
    }

    private static class BucketNode {
        int key;
        int value;
        BucketNode next;

        public BucketNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
