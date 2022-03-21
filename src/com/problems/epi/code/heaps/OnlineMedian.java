package com.problems.epi.code.heaps;

import java.util.*;

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
 * 4a. Also, the size property- if the size of the set is odd (2 * n + 1), the minHeap is allowed to hold n+1 elements while the maxHeap hold n elements. Otherwise, they both hold n elements. Thus, the size property needs to be checked, i.e. is the maxHeap.size() > minHeap.size()? If yes, move the front element (largest) of the maxHeap and add it to the minHeap (the element becomes then smallest in the minHeap).
 * 4b. The above condition can go both ways- if the size of the set is odd (2 * n + 1), the maxHeap is allowed to hold n+1 elements while the minHeap hold n elements. Otherwise, they both hold n elements. Thus, the size property needs to be checked, i.e. is the minHeap.size() > maxHeap.size()? If yes, move the front element (smallest) of the minHeap and add it to the maxHeap (the element becomes then largest in the maxHeap).
 * 5. Find the median- check if size of the set is odd or even (by checking if the size of the two heaps are the same). If odd, return the average of the front elements of the two heaps. Otherwise, return the largest element from the smaller half (i.e. the front element of the maxHeap) OR the smallest element from the larger half (i.e. the front element of the minHeap)
 * Be careful: Since median is a double, average is computed as (a+b)/2.0
 * Time complexity per entry: O(logn)
 * Space Complexity: O(n)
 */
public class OnlineMedian {

    public static List<Double> onlineMedian(Iterator<Integer> seq) {
        List<Double> res = new ArrayList<>();
        if(seq == null) return res;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while(seq.hasNext()) {
            Integer x = seq.next();
            //maxHeap.add(x); // as in 4a and 4b above- can go both ways
            minHeap.add(x);
            //minHeap.add(maxHeap.remove());
            maxHeap.add(minHeap.remove());
            //if(minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.remove());
            if(maxHeap.size() > minHeap.size()) minHeap.add(maxHeap.remove());
            //double median = maxHeap.size() == minHeap.size() ? 0.5 * (minHeap.peek() + maxHeap.peek()) : maxHeap.peek();
            double median = maxHeap.size() == minHeap.size() ? 0.5 * (minHeap.peek() + maxHeap.peek()) : minHeap.peek();
            res.add(median);
        }
        return res;
    }
}
