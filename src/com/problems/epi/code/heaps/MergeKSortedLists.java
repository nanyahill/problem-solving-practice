package com.problems.epi.code.heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Key Insights: Merging already sorted arrays into a single sorted array requires to select the minimum element seen so far and add it to the result set.
 * How do we get the minimum at all times? Use a Heap_Old (in Java this is implemented as a Priority Queue).
 * This problem has pratical implications especially when the memory size is insufficient to take all the arrays at once.
 * How the Algo works: Create a PQ, add the first elements from each array to the queue.
 * While the queue is not empty, dequeue from the front of the queue and enqueue the next element from the array where the dequeued element comes from.
 ** Note: When using PQ, you have to implement a Comparator OR Object stored needs to extend Comparable class
 */
public class MergeKSortedLists {

    public static class HeapNode implements Comparable<HeapNode> {
        public int value;
        public int id;

        HeapNode(int value, int id) {
            this.value = value;
            this.id = id;
        }

        public int compareTo(HeapNode node) {
            //return (this.value > node.value) ? 1 : (this.value == node.value) ? 0 : -1;
            return Integer.compare(this.value, node.value);
        }
    }

    public static List<Integer> mergeKSortedLists(List<List<Integer>> sortedArrays) {
        List<Integer> result = new ArrayList<>();
        if(sortedArrays == null || sortedArrays.size() == 0) return result;

        // A list of iterators is needed because you need to know the next element to insert in the queue
        // Alternatively, you can store the next index in your HeapNode class
        List<Iterator<Integer>> iters = new ArrayList<>();
        for(List<Integer> array : sortedArrays) iters.add(array.iterator());

        // Good idea to specify the size of the heap
        PriorityQueue<HeapNode> heap = new PriorityQueue<>(sortedArrays.size());
        for(int i = 0; i < sortedArrays.size(); i++) {
            if(iters.get(i).hasNext()) {
                heap.offer(new HeapNode(iters.get(i).next(), i));
            }
        }
        while(!heap.isEmpty()) {
            HeapNode node = heap.poll();
            result.add(node.value);
            int id = node.id;
            if(iters.get(id).hasNext()) {
                heap.offer(new HeapNode(iters.get(id).next(), id));
            }
        }
        return result;
    }
}
