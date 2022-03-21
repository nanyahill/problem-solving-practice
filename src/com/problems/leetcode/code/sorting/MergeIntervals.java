package com.problems.leetcode.code.sorting;

import com.problems.epi.code.sorting.UnionOfIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Leetcode #56
 */

public class MergeIntervals {
    private static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static List<Interval> mergeInterval(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval e1, Interval e2) {
                return Integer.compare(e1.start, e2.start);
            }
        });
        result.add(intervals.get(0));
        for(Interval interval : intervals) {
            Interval lastMerged = result.get(result.size() - 1);
            if(lastMerged.end >= interval.start) {
                lastMerged.end = Math.max(lastMerged.end, interval.end);
            }
            else result.add(interval);
        }
        return result;
    }
}
