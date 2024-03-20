package com.problems.epi.code.searching.general_search;

import java.util.List;

public class SearchForMinMaxInArray {
    public static class MinMax {
        public Integer smallest;
        public Integer largest;

        public MinMax(Integer smallest, Integer largest) {
            this.smallest = smallest;
            this.largest = largest;
        }

        private static MinMax minMax(Integer a, Integer b) {
            return Integer.compare(b, a) < 0 ? new MinMax(b, a) : new MinMax(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            MinMax minMax = (MinMax) o;

            if (!smallest.equals(minMax.smallest)) {
                return false;
            }
            return largest.equals(minMax.largest);
        }

        @Override
        public String toString() {
            return "min: " + smallest + ", max: " + largest;
        }
    }

    /**
     * Number of comparisons: O(n/2)
     */
    public static MinMax findMinMaxLeastNumberOfComparisons(List<Integer> nums) {
        if (nums == null) return null;
        if (nums.size() <= 1) return new MinMax(nums.get(0), nums.get(0));
        MinMax globalMinMax = MinMax.minMax(nums.get(0), nums.get(1));
        for (int i = 2; (i + 1) < nums.size(); i += 2) {
            MinMax localMinMax = MinMax.minMax(nums.get(i), nums.get(i + 1));
            globalMinMax = new MinMax(Math.min(globalMinMax.smallest, localMinMax.smallest), Math.max(globalMinMax.largest, localMinMax.largest));
        }
        if ((nums.size() % 2) != 0) {
            globalMinMax = new MinMax(Math.min(globalMinMax.smallest, nums.get(nums.size() - 1)), Math.max(globalMinMax.largest, nums.get(nums.size() - 1)));
        }
        return globalMinMax;
    }

    /**
     * Number of comparisons: O(n)
     */
    public static MinMax findMinMaxHighNumberOfComparisons(List<Integer> nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return min == Integer.MAX_VALUE && max == Integer.MIN_VALUE ? new MinMax(0, 0) : new MinMax(min, max);
    }
}
