package com.problems.epi.code.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Key Insight:
 * Definition of Median: Median is the middle value in an ordered integer list.
 * Specifically, in an ordered set where size of the set is an even number, median is the largest of the smaller half of the set.
 * In an ordered set where size of the set is an odd number, median is the average of the largest of the smaller half and the smallest of the larger half of the set.
 * The problem requires us to maintain an ordered set. (Think Insertin Sort)
 * Keeping the set ordered is NOT a requirement. Rather, the problem requires us to find the median quickly because it is a running sequence.
 * How can direct access to median elements be maintained at all times. What data structure can be used? (Think Heaps, Self Balancing trees)
 * Algorithm:
 * 1. Create two heaps- maxHeap (maintains collection of elements in the smaller half of the set(left hand side)) and minHeap (maintains collection of elements in the larger half of the set (right hand side)).
 * 2. Moving from left to right, assume a new element belongs to the smaller half set, thus, add element to the maxHeap.
 * 3. Since maxHeap received a new element, it is required to balance the minHeap as well. Thus, take the largest from the maxHeap (the front element) and add it to the minHeap. This step is called the balancing step.
 * 4. Also, the size property- if the size of the set is odd (2 * -[[[[[[[[[[[[[[[[[;n + 1), the maxHeap is allowed to hold n+1 elements while the minHeap hold n elements. Otherwise, they both hold n elements. Thus, the size property needs to be checked, i.e. is the minHeap.size() > maxHeap.size()? If yes, move the front element (smallest) of the minHeap and add it to the maxHeap (the element becomes then largest in the maxHeap).
 * 5. Find the median- check if size of the set is odd or even (by checking if the size of the two heaps are the same). If even, return the average of the front elements of the two heaps. Otherwise, return the largest element from the smaler half (i.e. the front element of the maxHeap).
 * Be careful: Since median is a double, average is computed as (a+b)/2.0
 * Time complexity per entry: O(logn)
 * Space Complexity: O(n)
 */
public class OnlineMedian {

    public static List<Double> onlineMedian(List<Integer> seq) {
        if(seq == null || seq.size() == 0) return null;
        List<Double> res = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer val : seq) {
            maxHeap.offer(val);
            minHeap.add(maxHeap.poll());
            if(maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
            double median = (maxHeap.size() == minHeap.size()) ? (maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
            res.add(median);
        }
        return res;
    }
}
