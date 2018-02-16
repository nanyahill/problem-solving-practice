package com.problems.epi.code.searching.binary_search;

/**
 * Key Insight:
 - The input is a floating point number.
 - Square roots of some floating point numbers are greater than the number but less than 1.0, for example, when x = 0.25.
    However, for floating point numbers greater than 1.0, the square root is less than the number.
 - Thus, use the above condition to determine your left and right boundaries
 - Note than when comparing the square of the mid to the number, it wold be a comparison of two floating point numbers.
   Hence , you can use normalization for precision problem (see the EPI book).
 - Changes to typical binary search algorithm:
 - Also, when if the square of the mid is larger than the input number, move to the left side of the range 	by making hi = mid rather than mid - 1. Same applies to lo.
 - The loop needs to continue until lo != hi rather than lo <= hi. This is because of the finite precision arithmetic involved.
 */
public class ComputeRealSquareRoot {

    public static double computeRealSquareRoot(double x) {
        double lo, hi;
        if(x < 1.0) {
            lo= x;
            hi = 1.0;
        }
        else {
            lo = 1.0;
            hi = x;
        }
        while(compare(lo, hi) != Ordering.EQUAL) {
            double mid = lo + 0.5 * (hi - lo);
            double midSquared = mid * mid;
            if(compare(midSquared, x) == Ordering.LARGER) hi = mid;
            else lo = mid;
        }
        return lo;
    }

    public enum Ordering { SMALLER, EQUAL, LARGER }

    public static Ordering compare(double a, double b) {
        final double EPSILON = 0.00001;
        // Uses normalization for precision problem.
        double diff = (a - b) / b; // In textbook, (a - b) / Math.max(Math.abs(a), Math.abs(b));
        return diff < -EPSILON
                ? Ordering.SMALLER
                : (diff > EPSILON ? Ordering.LARGER : Ordering.EQUAL);
    }
}
