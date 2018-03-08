package com.problems.epi.test.sorting;

import com.problems.epi.code.sorting.UnionOfIntervals;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UnionOfIntervalsTest {

    @Test
    public void unionOfIntervalsTest() {
        List<UnionOfIntervals.Interval> input = new ArrayList<>();
        input.add(new UnionOfIntervals.Interval(13,15));
        input.add(new UnionOfIntervals.Interval(0,3));
        input.add(new UnionOfIntervals.Interval(1,1));
        input.add(new UnionOfIntervals.Interval(5,7));
        input.add(new UnionOfIntervals.Interval(2,4));
        input.add(new UnionOfIntervals.Interval(3,4));
        input.add(new UnionOfIntervals.Interval(9,11));
        input.add(new UnionOfIntervals.Interval(16,17));
        input.add(new UnionOfIntervals.Interval(12,14));
        input.add(new UnionOfIntervals.Interval(8,11));
        input.add(new UnionOfIntervals.Interval(12,16));
        input.add(new UnionOfIntervals.Interval(7,8));
        List<UnionOfIntervals.Interval> expected = new ArrayList<>();
        expected.add(new UnionOfIntervals.Interval(0,4));
        expected.add(new UnionOfIntervals.Interval(5,11));
        expected.add(new UnionOfIntervals.Interval(12,17));
        List<UnionOfIntervals.Interval> actual = UnionOfIntervals.unionOfIntervals(input);
        assert(expected.get(0).start == actual.get(0).start);
        assert(expected.get(0).end == actual.get(0).end);
        assert(expected.get(1).start == actual.get(1).start);
        assert(expected.get(1).end == actual.get(1).end);
        assert(expected.get(2).start == actual.get(2).start);
        assert(expected.get(2).end == actual.get(2).end);
    }

}
