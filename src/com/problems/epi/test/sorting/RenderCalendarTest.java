package com.problems.epi.test.sorting;

import com.problems.epi.code.sorting.RenderCalendar;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RenderCalendarTest {

    @Test
    public void findMaxOverLappingEventsTest() {
        List<RenderCalendar.Event> events = Arrays.asList(
                new RenderCalendar.Event(1, 5), new RenderCalendar.Event(2, 7), new RenderCalendar.Event(4, 5), new RenderCalendar.Event(6, 10),
                new RenderCalendar.Event(8, 9), new RenderCalendar.Event(9, 17), new RenderCalendar.Event(11, 13), new RenderCalendar.Event(12, 15),
                new RenderCalendar.Event(14, 15));
        int expected = 3;
        int actual = RenderCalendar.findMaxOverlapingEvents_TwoPointer(events.toArray(new RenderCalendar.Event[0]));
        assert (expected == actual);
    }

    @Test
    public void findMaxOverLappingEventsTest_BigData() {
        int N = 1000000;
        List<RenderCalendar.Event> big1 = new ArrayList<>(N);
        List<RenderCalendar.Event> big2 = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            big1.add(new RenderCalendar.Event(i, i));
            big2.add(new RenderCalendar.Event(-i, i));
        }
        int expected = N;
        int actual = RenderCalendar.findMaxOverLappingEvents(big2);
    }
}
