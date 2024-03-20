package com.problems.sandbox;

import java.util.Arrays;

public class Main {
        // Function to find maximum overlapping interval
        public static void maximumOverlappingIntervals(int[] arrival, int[] departure)
        {
            // Find the time when the last interval ends
            int time = Arrays.stream(departure).max().getAsInt();

            // Create count array initialized with 0
            int[] count = new int[time + 2];

            // Fill the count array range count using the array index to store time
            for (int i = 0; i < arrival.length; i++)
            {
                for (int j = arrival[i]; j <= departure[i]; j++) {
                    count[j]++;
                }
            }

            // Keep track of the time when maximum range overlaps
            int max_event_tm = 0;

            // Find the the maximum element in the count array
            for (int i = 0; i <= time; i++)
            {
                if (count[max_event_tm] < count[i]) {
                    max_event_tm = i;
                }
            }
            System.out.println("The maximum number of Overlapping intervals is: " + count[max_event_tm]);
        }

        public static void main(String[] args) {
//            int[] arrival = {0, 3, 4, 7, 1};
//            int[] departure = {2, 7, 6, 8, 5};
            int[] arrival = {0, 3};//, 4, 7, 1};
            int[] departure = {2, 7};//, 6, 8, 5};

            maximumOverlappingIntervals(arrival, departure);
        }

}
