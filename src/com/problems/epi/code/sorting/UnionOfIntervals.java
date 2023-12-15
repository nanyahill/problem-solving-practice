package com.problems.epi.code.sorting;

import java.util.*;

/**
 * Pattern: Sweep Line Algo & Sorting
 This problem is also called Merge Intervals on leetcode

 ****************************************************************************

 Key Insight:
 - Intervals where there is a start and an end that correspond to points in a plane. (Think of Sweep Line Algo, Sorting).
 - Finding the union/merge of intervals so that result is a list of disjoint intervals. (Think sorting)
 - Sorting the intervals based on their start values forms a list of mergable intervals in a contiguous block.
 - Overlap happens when the end of prev interval is GREATER THAN/EQUAL TO the start of the curr interval.
 Brute Force:
 - For each interval, find all overalapping intervals and then merge these intervals
 Time Complexity: O(n^2), Space Complexity: O(1) (in-place: because when you are done with these intervals, they can be removed).

 ****************************************************************************

 Efficient Algorithm with O(n) space:
 - Sort intervals based on start point
 - For each interval in sorted list, check for overlaps by:
 - Comparing the end of previous interval with the start of the current interval
 - if overlap exists (i.e. previous end is greater than current start)
 - update previous end, if previous end is less than current end.
 - if no overlap, add global start and end variables in the result.
 - reset the global start and end variables to the current interval's start and end.
 NOTE: - If you use global variables, make sure you update the result just before returning from the method
 - To prevent the above, update the content of the result list as you iterate over the sorted list of intervals.
 *******************************************
 Efficient Algorithm with O(1) space:(pseudo two pointer)
 - Sort intervals based on start point
 - Iterate over sorted list from 0 to n - 2 (because we always compare i and i + 1):
 - Select first two intervals with an i pointer on the first interval, check for overlap by comparing the end of first interval with the start of the second interval.
 - if overlap exists, update first end, if first end is less than second end.
 - delete the second interval from the list.
 - if no overlap, increment the pointer i.

 ****************************************************************************

 Algorithm based on RenderCalendar problem solution:
 Key idea: Counting the number of overlaps in a set of intervals and knowing you are done when count becomes 0.
 - Regard all points in the intervals as endpoints. That is for n intervals, there are 2*n endpoints.
 - Create a nested class (i.e. static inner) of EndPoints and indicate which endpoint is the start.
 - Create a list of endpoints from the list of intervals.
 - Sort the list of endpoints based on start. Break ties by placing start endpoints before end endpoints.
 - Use a minStart and maxEnd variable to keep track of the min start endpoint seen and the max end endpoint seen so far.
 - Iterate over list and increment counter for start endpoints and decrement counter for end end points.
 - Update the minStart and maxEnd whenever the counter increments or decrements.
 - When the counter is 0, we know we have hit the end of a mergable interval. Thus, add the interval to result. Reset minStart and maxEnd.
 Note: Issues with this solution is that we have to maintain another inner class called EndPoint which may be superflous considering that the Interval class is already an inner class already maintained.
 */

public class UnionOfIntervals {

    public static class Interval {
        public int start;
        public int end;
        public Interval() {}
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /** Time Complexity: O(nlogn), Space: O(n) */
    public static List<Interval> unionOfIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return Collections.emptyList();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (!res.isEmpty() && (res.get(res.size() - 1).end >= interval.start)) { // as long as the points touch they overlap; case for the equal to
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, interval.end);
            } else {
                res.add(interval);
            }
        }
        return  res;
    }

    /** Time: O(nlogn), Space: O(1) */
    public static List<Interval> unionOfIntervals_ConstantSpace(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return Collections.EMPTY_LIST;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }});
        // Use Lambda
        //intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        int i = 0;
        while(i < intervals.size() - 1) {

            Interval a = intervals.get(i);
            Interval b = intervals.get(i + 1);
            if(b.start <= a.end) { // as long as the points touch they overlap; case for the equal to
                a.end = Math.max(a.end, b.end);
                intervals.remove(i + 1);
            }
            else i++;
        }
        return intervals;
    }

    public static class EndPoint {
        int value;
        boolean isStart;
        public EndPoint(int value, boolean isStart) {
            this.value = value;
            this.isStart = isStart;
        }
    }
    /** Time Complexity: O(nlogn), Space: O(n)
     * This method uses the idea from the render calendar problem
     */
    public List<Interval> unionOfIntervals_CountOverLaps(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return Collections.EMPTY_LIST;
        List<EndPoint> endPoints = new ArrayList<>();
        for(Interval e : intervals) {
            endPoints.add(new EndPoint(e.start, true));
            endPoints.add(new EndPoint(e.end, false));
        }
        Collections.sort(endPoints, new Comparator<EndPoint>() {
            public int compare(EndPoint e1, EndPoint e2) {
                if(e1.value != e2.value) return Integer.compare(e1.value, e2.value);
                // if times are equal, break tie by checking if either one is start time. Start time comes first
                return e1.isStart && !e2.isStart ? -1 : !e1.isStart && e2.isStart ? 1 : 0;
            }});
        int countSeenSoFar = 0;
        int minStart = Integer.MAX_VALUE, maxEnd = Integer.MIN_VALUE;
        List<Interval> res = new ArrayList<Interval>();
        for(EndPoint ep : endPoints) {
            if(ep.isStart) {
                countSeenSoFar++;
                minStart = Math.min(minStart, ep.value);
            }
            else {
                countSeenSoFar--;
                maxEnd = Math.max(maxEnd, ep.value);
            }
            if (countSeenSoFar == 0) { // End of one mergeable interval
                res.add(new Interval(minStart, maxEnd));
                minStart = Integer.MAX_VALUE;
                maxEnd = Integer.MIN_VALUE;
            }
        }
        return res;
    }

    /** Time Complexity: O(nlogn), Space: O(n)
     * This solution is for the EPI question where closed and open intervals are taken into consideration
     * Note: In EPIJudge, the if statemnets on line 192 and 193 could be written as >= (or <=) but that would not pass all the testcases
     * I believe it's related to how they may have implemented the equals() and hashCode fxns for the interval object internally
     *
     */
    public static class Interval_EPI implements Comparable<Interval_EPI>{
        public Endpoint left = new Endpoint();
        public Endpoint right = new Endpoint();

        @Override
        public int compareTo(Interval_EPI o) {
            if(this.left.val != o.left.val) {
                return Integer.compare(this.left.val, o.left.val);
            }
            if(this.left.isClosed && !o.left.isClosed) {
                return -1;
            }
            return (!this.left.isClosed && o.left.isClosed) ? 1: 0;
        }

        private static class Endpoint {
            public boolean isClosed;
            public int val;
        }
    }

    public static List<Interval_EPI> unionOfIntervals_EPI(List<Interval_EPI> intervals) {
        if(intervals == null || intervals.size() == 0) {
            return Collections.emptyList();
        }
        List<Interval_EPI> result = new ArrayList<>();
        Collections.sort(intervals);
        for(Interval_EPI interval : intervals) {
            if(!result.isEmpty() && (result.get(result.size() - 1).right.val > interval.left.val || result.get(result.size() - 1).right.val == interval.left.val && (result.get(result.size() - 1).right.isClosed || interval.left.isClosed))) {
                if (interval.right.val > result.get(result.size() - 1).right.val || interval.right.val == result.get(result.size() - 1).right.val &&
                        interval.right.isClosed) {
                    result.get(result.size() - 1).right = interval.right;
                }
            }
            else {
                result.add(interval);
            }
        }
        return result;
    }

    // Leetcode 56 solution
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return res.toArray(new int[res.size()][]);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int start = intervals[0][0], end = intervals[0][1];
        for (int[] interval : intervals) {

            if (interval[0] <= end) { // as long as the points touch they overlap; case for the equal to
                end = Math.max(end, interval[1]);
            } else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end}); // not needed if res is updated in the loop
        return res.toArray(new int[res.size()][]);
    }
}
