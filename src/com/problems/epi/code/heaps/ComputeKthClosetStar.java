package com.problems.epi.code.heaps;

import java.util.*;

/**
 * Key Insight: Since the number of stars is large- one trillion.
 * Finding the kth elment will require a data structure that would use less space (i.e. k-space).
 * A heap comes to mind. Would it be a max heap or a min heap?
 * Well, since we are looking for the k closet (i.e. shortest distance from the earth) stars,
 * then we need to evict any star that has the largest distance from Earth from a candidate set of stars. Hence, max heap will be ideal.
 * Algorithm: Keeping adding stars to the heap until heap size is greater than k. Then evict the largest entry in the heap.
 ** Note that the result is a sorted (from largest to smallest) set of distance.
 ** This result can be returned as is or sorted to get the reverse of  the sorted set.
 */
public class ComputeKthClosetStar {

    public static class Coords {
        double x, y, z;

        public Coords(double x, double y, double z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static class Star implements Comparable<Star> {
        Coords coord;
        public double distance;
        public int id;

        public Star(Coords coord, int id) {
            this.coord = coord;
            this.id = id;
        }

        public void distance() {
            this.distance = Math.sqrt((coord.x * coord.x) + (coord.y * coord.y) + (coord.z * coord.z));
        }

        public int compareTo(Star s) { return Double.compare(this.distance, s.distance); }
    }

    public static List<Star> computeKthClosetStars(List<Star> stars, int k) {
        if(stars == null || stars.size() == 0) return null;
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Iterator<Star> starIterator = stars.iterator();
        while(starIterator.hasNext()) {
            Star s = starIterator.next();
            maxHeap.offer(s);
            if(maxHeap.size() == k + 1) maxHeap.poll();
        }
        List<Star> result = new ArrayList<>(maxHeap);
        Collections.sort(result);
        return result;
    }
}
