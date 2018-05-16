package com.problems.epi.test.recursion;

import com.problems.epi.code.recursion.TowerOfHanoi;
import org.junit.Test;

public class TowerOfHanoiTest {

    final static int NUM_OF_PEGS = 3;
    final static int NUM_OF_DISKS = 6;

    @Test
    public void computeTowerOfHanoiTest() {
        TowerOfHanoi th = new TowerOfHanoi(NUM_OF_PEGS, NUM_OF_DISKS);
        th.computeTowerOfHanoi(NUM_OF_DISKS, th.pegs, 0, 1, 2);
    }
}
