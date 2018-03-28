package com.problems.epi.code.heaps;

import java.util.*;

/**
 * Key Insight:
 * The array is almost sorted. (Think Insertion Sort (IS). IS works really well for best-case scenarios)
 * Each element is at most k spaces away from its correct position (Think IS still, Heaps)
 * The input is a large sequence of numbers and array is k-sorted (Think Heaps)
 */
public class SortApproximatelySorted {

    /**
     * Min-Heap_Old Method: Performs well for large values of k and sequence
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     */
    public static List<Integer> sortAlmostSorted_Heap(List<Integer> sequence, int k) {
        if (sequence == null || sequence.size() == 0) return null;
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(sequence.size());
        Iterator<Integer> seqIter = sequence.iterator();
        while (minHeap.size() < k && seqIter.hasNext()) minHeap.offer(seqIter.next());
        while (seqIter.hasNext()) {
            minHeap.offer(seqIter.next());
            res.add(minHeap.poll());
        }
        while (!minHeap.isEmpty()) res.add(minHeap.poll());
        return res;
    }

    /**
     * Insertion Sort Method: Performs well for small values of k and sequence
     * Time Complexity: O(nk)
     * Space Complexity: O(1) inplace
     */
    public static List<Integer> sortAlmostSorted_InsertionSort(List<Integer> sequence, int k) {
        if (sequence == null || sequence.size() == 0) return null;
        for (int i = 0; i < sequence.size(); i++) {
            int val = sequence.get(i);
            int idx = i;
            while (idx > 0 && val < sequence.get(idx - 1)) {
                Collections.swap(sequence, idx, idx - 1);
                idx--;
            }
        }
        return sequence;
    }

    /**
     * Regular Sort Method: Does not use the fact that array is k-sorted
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1) inplace
     */
    public static List<Integer> sortAlmostSorted_Sort(List<Integer> sequence, int k) {
        if (sequence == null || sequence.size() == 0) return null;
        Collections.sort(sequence);
        return sequence;
    }
}
