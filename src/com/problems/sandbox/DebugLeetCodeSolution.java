package com.problems.sandbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class DebugLeetCodeSolution {

    public static class Interval {
        public int start;
        public int end;
        public Interval() {}
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals[0].length == 0) return null;
        List<Interval> listOfIntervals = new ArrayList<>();
        for(int[] interval : intervals) {
            listOfIntervals.add(new Interval(interval[0], interval[1]));
        }
        Collections.sort(listOfIntervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<Interval> result = new ArrayList<>();
        for(int i = 0; i < listOfIntervals.size(); i++) {
            if(end >= listOfIntervals.get(i).start) {
                end = Math.max(end, listOfIntervals.get(i).end);
            }
            else {
                result.add(new Interval(start, end));
                start = listOfIntervals.get(i).start;
                end = listOfIntervals.get(i).end;
            }
        }
        result.add(new Interval(start, end));
        int[][] resultAsArray = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            resultAsArray[i][0] = result.get(i).start;
            resultAsArray[i][1] = result.get(i).end;
        }
        return resultAsArray;
    }

    public static void main(String args[]) {
        DebugLeetCodeSolution d = new DebugLeetCodeSolution();
        merge(new int[][] {{1,4},{0,4}});
    }
}