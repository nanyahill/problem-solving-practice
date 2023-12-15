package com.problems.epi.code.sorting;

import java.util.*;

/**
 * Problem Type:  Sorting, Geometric
 * Pattern: Sweep-Line Algorithm (https://www.youtube.com/watch?v=dePDHVovJlE)
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
        public int start;
        public int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    private static class TimePoint implements Comparable <TimePoint>{
        public int time;
        public boolean isStart;
        public TimePoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
        public int compareTo(TimePoint p) {
            if(time != p.time) return Integer.compare(time, p.time);
            return isStart && !p.isStart ? -1 : !isStart && p.isStart ? 1  : 0;
        }
    }

    public static int findMaxOverLappingEvents(List<Event> events) {
        if(events == null || events.size() == 0) return -1;
        int maxNumberOfEvents = Integer.MIN_VALUE;
        int countEvents = 0;
        List<TimePoint> points = new ArrayList<>();
        for(Event e : events) {
            points.add(new TimePoint(e.start, true));
            points.add(new TimePoint(e.end, false));
        }
        Collections.sort(points, new Comparator<TimePoint>() { // or use Lambda or Comparable interface
            public int compare(TimePoint p1, TimePoint p2) {
                if(p1.time != p2.time) return Integer.compare(p1.time, p2.time);
                return p1.isStart && !p2.isStart ? -1 : !p1.isStart && p2.isStart ? 1  : 0;
            }
        });
        for(int i = 0; i < points.size(); i++) {
            if(points.get(i).isStart == true) {
                countEvents++;
                maxNumberOfEvents = Math.max(countEvents, maxNumberOfEvents);
            }
            else countEvents--;
        }
        return maxNumberOfEvents;
    }

    public static int findMaxOverlapingEvents_TwoPointer2(Event[] events) {
        if (events == null || events.length == 0) return -1;
        int countSeenSoFar = 0, maxCountSeenSoFar = 0;
        List<Integer> startPoints = new ArrayList<>();
        List<Integer> endPoints = new ArrayList<>();
        for(Event e : events) {
            startPoints.add(e.start);
            endPoints.add(e.end);
        }
        Collections.sort(startPoints);
        Collections.sort(endPoints);
        int i = 0, j = 0; // because i is the fast pointer while j is the slow pointer
        //for(int i = 1; i < events.length && j < events.length; i++) {
        while (i < events.length && j < events.length) {
            if (startPoints.get(i) <= endPoints.get(j)) {
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

    public static int findMaxOverlapingEvents_TwoPointer(Event[] events) {
        if (events == null || events.length == 0) return -1;
        Arrays.sort(events);
        int count = 0;
        int maxCountSeenSoFar = 0;
        for(int i = 0; i < events.length - 1; i++) {
            Event curr = events[i];
            Event next = events[i + 1];
            if(curr.end >= next.start) {
                count++;
                Math.max(count, maxCountSeenSoFar);
            }
            else count = 0;

        }
        return maxCountSeenSoFar;
    }

    private static void check(int expected, List<Event> events) {
        int got = findMaxOverLappingEvents(events);
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
