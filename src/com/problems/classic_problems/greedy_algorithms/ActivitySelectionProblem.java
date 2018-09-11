package com.problems.classic_problems.greedy_algorithms;

import java.util.Arrays;
import java.util.Comparator;

/*
 * The activity selection problem is a combinatorial optimization problem concerning the selection of
 * non-conflicting activities to perform within a given time frame, given a set of activities each marked
 * by a start time (si) and finish time (fi). The problem is to select the maximum number of activities that
 * can be performed by a single person or machine, assuming that a person can only work on a single activity
 * at a time. Also, known as the Interval Scheduling problem.
 * A classic application of this problem is in scheduling a room for multiple competing events, each having
 * its own time requirements (start and end time), and many more arise within the framework of operations research.
 * Source: Wikipedia
 */
public class ActivitySelectionProblem {

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

    public int findMaxOverLappingProblems(Event[] events) {
        if(events == null || events.length == 0) return 0;
        Arrays.sort(events, new EventComparator());
        int count = 1;
        int endTime = events[0].end;
        for(int i = 1; i < events.length; i++) {
            if(events[i].start >= endTime) {
                count++;
                endTime = events[i].end;
            }
        }
        return count;
    }
}
