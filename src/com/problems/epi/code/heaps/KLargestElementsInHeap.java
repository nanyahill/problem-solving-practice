package com.problems.epi.code.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElementsInHeap {

    /**
     * Time: O(nlogk)
     * Space: O(k)
     */
    public static List<Integer> kLargestInBinaryHeapLessEfficient(List<Integer> nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums == null) return result;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        result = new ArrayList<>(minHeap);
        Collections.sort(result);
        return result;
    }

    /**
     * Time: O(klogk)
     * Space: O(k)
     */
    public static List<Integer> kLargestInBinaryHeap(List<Integer> nums, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(new HeapEntry(nums.get(0), 0));
        for(int i = 0; i < k; i++) {
            HeapEntry entry = maxHeap.remove();
            result.add(entry.val);
            int entryIdx = entry.idx;
            int leftChildIdx = 2 * entryIdx + 1;
            if(leftChildIdx < nums.size()) {
                maxHeap.add(new HeapEntry(nums.get(leftChildIdx), leftChildIdx));
            }
            int rightChildIdx = 2 * entryIdx + 2;
            if(rightChildIdx < nums.size()) {
                maxHeap.add(new HeapEntry(nums.get(rightChildIdx), rightChildIdx));
            }
        }
        return result;
    }

    private static class HeapEntry implements Comparable<HeapEntry> {
        int val;
        int idx;
        public HeapEntry(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        public int compareTo(HeapEntry that) {
            return Integer.compare(this.val, that.val);
        }
    }
}
