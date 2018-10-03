package com.problems.ctci.chapter10;

public class Question10_4 {

    public static int search(Listy nums, int key) {
        if(nums == null) return -1;
        int index = 1;
        while(nums.elementAt(index) != -1 && nums.elementAt(index) < key) index *= 2;
        return binarySearch(nums, key, 0, index);
    }

    private static int binarySearch(Listy nums, int key, int lo, int hi) {
        while(lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if(nums.elementAt(mid) > key || nums.elementAt(mid) == -1) hi = mid - 1;
            else if(nums.elementAt(mid) < key) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static class Listy {
        int[] array;

        public Listy(int[] arr) {
            array = arr.clone();
        }

        public int elementAt(int index) {
            if (index >= array.length) {
                return -1;
            }
            return array[index];
        }
    }
}
