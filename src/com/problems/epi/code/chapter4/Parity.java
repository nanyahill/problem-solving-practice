package com.problems.epi.code.chapter4;

/**
 * Created by Nanya on 11/8/17.
 */
public class Parity {

    public short computeParity(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 1);
    }
}
