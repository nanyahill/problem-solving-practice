package com.problems.epi.code.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Similar to Leetcode #57: Insert Interval
 */
public class MergingIntervalsWithNewInterval {

    private static class Event {
        int start;
        int end;
        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Event> mergeIntervalWithNewInterval(List<Event> events, Event newEvent) {
        List<Event> result = new ArrayList<>();
        if(events == null) return result;
        int i = 0;
        while(i < events.size() && events.get(i).end < newEvent.start) result.add(events.get(i++)); // while they do not intersect
        while(i < events.size() && newEvent.end >= events.get(i).start) { // while they intersect
            int start = Math.min(events.get(i).start, newEvent.start);
            int end = Math.max(events.get(i).end, newEvent.end);
            newEvent = new Event(start, end);
            i++;
        }
        result.add(newEvent);
        while(i < events.size()) result.add(events.get(i++)); // add the rest of the intervals
        return result;
    }
}
