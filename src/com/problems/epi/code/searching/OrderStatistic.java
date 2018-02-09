package com.problems.epi.code.searching;

import java.util.NoSuchElementException;
import java.util.Random;

public class OrderStatistic {
    public static int findKthLargest(int[] A, int k) {
        if(A == null || A.length == 0) return 0;
        int lo = 0, hi = A.length - 1;
        Random rand = new Random();
        k = A.length - k;
        while(lo <= hi) {
            int pvt = rand.nextInt(hi - lo + 1) + lo;
            int j = partition(A, lo, hi, A[pvt]);
            if(j == k) return A[k];
            else if(j < k) lo = j + 1;
            else hi = j - 1;
        }
        return 0;
    }

    private static int partition(int[] A, int lo, int hi, int pvt) {
        if(A == null || A.length == 0) throw new IllegalStateException();
        //hi = hi + 1;
        while(lo < hi) {
            while(A[lo++] < pvt) if(lo == hi) break;
            while(A[hi--] > pvt) if(hi == lo) break;
            //if(lo >= hi) break;
            swap(A, lo, hi);
        }
        return hi;
    }

    private static void swap(int[] A, int lo, int hi) {
        if(A == null || A.length == 0) throw new IllegalStateException();
        int tmp = A[lo];
        A[lo] = A[hi];
        A[hi] = tmp;
    }
}
