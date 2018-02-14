package com.problems.epi.code.searching;

import com.problems.epi.code.heaps.ComputeKthClosetStar;

import java.util.Random;

public class OrderStatistic {
    public static Comparable findKthLargest(Comparable[] A, int k) {
        if(A == null || A.length == 0) return 0;
        int lo = 0, hi = A.length - 1;
        Random rand = new Random();
        k = A.length - k;
        while(lo < hi) {
            int pvt = rand.nextInt(hi - lo + 1) + lo;
            swap(A, lo, pvt);
            int j = partition(A, lo, hi);
            if(j == k) break;
            else if(j < k) lo = j + 1;
            else hi = j - 1;
        }
        return A[k];
    }

    private static int partition(Comparable[] A, int lo, int hi) {
        if(A == null || A.length == 0) throw new IllegalStateException();
        int i = lo;
        int j = hi + 1;
        while(true) { // could also say while(i < j) but this would always be true due to the inner if statement
            while(i < hi && A[++i] < A[lo]);
            while(j > lo && A[--j] > A[lo]);
            if(i >= j) break;
            swap(A, i, j);
        }
        swap(A, lo, j);
        return j;
    }

    private static void swap(Comparable[] A, int i, int j) {
        if(A == null || A.length == 0) throw new IllegalStateException();
        Comparable tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        Comparable[] in = {2, 1};
        System.out.print(findKthLargest(in, 1));
    }
}
