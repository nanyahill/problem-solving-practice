package com.problems.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Leetcode #435
 */
public class MinimumNumberOfEventsToRemove {

    private static class Event {
        public int start;
        public int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class EventComparator implements Comparator<Event> {
        public int compare(Event a, Event b) {
            return Integer.compare(a.end, b.end);
        }
    }

    public int removeOverlappingEvents(Event[] events) {
        if(events == null || events.length == 0) return 0;
        Arrays.sort(events, new EventComparator());
        int count = 1;
        int earliestEnd = events[0].end;
        for(int i = 1; i < events.length; i++) {
            if(events[i].start >= earliestEnd) {
                count++;
                earliestEnd = events[i].end;
            }
        }
        return events.length - count;
    }
}
