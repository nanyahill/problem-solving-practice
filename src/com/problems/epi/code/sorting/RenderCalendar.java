package com.problems.epi.code.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Type:  Sorting, Geometric
 * Pattern: Sweep-Line Algorithm
 * Key Insight:
 * - This problem is easier to visualize in a cartesian plane where each event is a rectangle. All events have the same height wrt the y-axis.
 * Thus, the problem boils down to finding the the maximum number of overlapping rectangles.
 * - If events are laid out based on start and end times in the cartesian plane;
 * it is resembles a sorted appearance of all the events based on start and end times.
 * - Brute-Force: For each event, count the number of events that contain it, using countSeenSoFar, and update the maxCountSeenSoFar.
 * - Efficient Algorithm:
 * - For each event, create endpoints for the start time and end time. Indicate which endpoint is a start time and which is end.
 * Note that another way to avoid creating a new EndPoint class is to use two arrays to store the start times and end times.
 * - Sort the array of endpoints (if not using Endpoints, sort the two arrays mentioned above) in ascending order.
 * If two endpoints have equal times, break tie by placing the time that is a start time first. Else, break tie arbitrarily.
 * Sorting this way creates a contiguous run of events with overlapping start times.
 * - Iterate over sorted array and increment countSeenSoFar and maxCountSeenSoFar whenever the endpoint is a start time, Else, decrement the countSeenSoFar.
 * Time complexity: O(nlogn), Space Complexity: O(n)
 * - Efficient Algorithm (Two Pointer) and Sweep Line Algo
 *  Have two pointers, i and j. i is ahead of j.
 *  At each iteration, exactly two intervals are compared
 *  If an overlap occurs, advance the faster pointer i and increment count, always check for the max seen so far.
 *  Else advance the slow pointer j, decrement count.
 */
public class RenderCalendar {

    public static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class EndPoint {
        int time;
        boolean isStart;

        public EndPoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public static int findMaxOverLappingEvents(Event[] events) {
        if (events == null || events.length == 0) return -1;
        EndPoint[] endPoints = new EndPoint[events.length * 2];
        int idx = 0;
        for (Event e : events) {
            endPoints[idx++] = new EndPoint(e.start, true);
            endPoints[idx++] = new EndPoint(e.end, false);
        }
        // Testing out Java 8 Lambda function for use with Comparator
        Arrays.sort(endPoints, (EndPoint e1, EndPoint e2) -> {
            if (e1.time != e2.time) return Integer.compare(e1.time, e2.time);
            // if times are equal, break tie by checking if either one is start time. Start time comes first
            return e1.isStart && !e2.isStart ? -1 : !e1.isStart && e2.isStart ? 1 : 0;
        });

        int countSeenSoFar = 0, maxCountSeenSoFar = -1;
        for (int i = 0; i < endPoints.length; i++) {
            if (endPoints[i].isStart) {
                countSeenSoFar++;
                maxCountSeenSoFar = Math.max(maxCountSeenSoFar, countSeenSoFar);
            } else countSeenSoFar--;
        }
        return maxCountSeenSoFar;
    }

    public static int findMaxOverlapingEvents_TwoPointer(Event[] events) {
        if (events == null || events.length == 0) return -1;
        int countSeenSoFar = 0, maxCountSeenSoFar = 0;
        int i = 1, j = 0; // because i is the fast pointer while j is the slow pointer
        //for(int i = 1; i < events.length && j < events.length; i++) {
        while (i < events.length && j < events.length) {
            if (events[i].start <= events[j].end) {
                countSeenSoFar++;
                maxCountSeenSoFar = Math.max(maxCountSeenSoFar, countSeenSoFar);
                i++;
            } else {
                countSeenSoFar--;
                j++;
            }
        }
        return maxCountSeenSoFar;
    }

    private static void check(int expected, List<Event> events) {
        int got = findMaxOverLappingEvents(events.toArray(new Event[0]));
        if (expected != got) {
            System.err.println("Failed on input " + events);
            System.err.println("Expected " + expected);
            System.err.println("Got " + got);
            System.exit(-1);
        }
        System.err.println("Expected " + expected);
        System.err.println("Got " + got);
    }

    private static void simpleTest() {
        List<Event> events = Arrays.asList(
                new Event(1, 5), new Event(2, 7), new Event(4, 5), new Event(6, 10),
                new Event(8, 9), new Event(9, 17), new Event(11, 13), new Event(12, 15),
                new Event(14, 15));
        check(3, events);
        events = Arrays.asList(new Event(1, 5), new Event(2, 7), new Event(4, 5),
                new Event(6, 10), new Event(8, 9), new Event(9, 17),
                new Event(11, 13), new Event(12, 15),
                new Event(14, 15), new Event(9, 10));
        check(4, events);

        check(1, Arrays.asList(new Event(1, 2), new Event(3, 4)));
        check(2, Arrays.asList(new Event(1, 3), new Event(3, 4)));
        check(2, Arrays.asList(new Event(1, 3), new Event(0, 4)));
        check(2, Arrays.asList(new Event(1, 3), new Event(0, 4), new Event(-1, 0)));
        check(2, Arrays.asList(new Event(1, 1), new Event(0, 0), new Event(0, 0)));
        int N = 1000000;
        List<Event> big1 = new ArrayList<>(N);
        List<Event> big2 = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            big1.add(new Event(i, i));
            big2.add(new Event(-i, i));
        }
        check(1, big1);
        check(N, big2);
    }

    public static void main(String[] args) {
        simpleTest();
    }
}
