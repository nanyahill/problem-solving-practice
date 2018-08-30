package com.problems.epi.test.recursion;

import com.problems.epi.code.recursion.TowerOfHanoi;
import org.junit.Test;

public class TowerOfHanoiTest {

    final static int NUM_OF_PEGS = 3;
    final static int NUM_OF_DISKS = 3;

    @Test
    public void computeTowerOfHanoiTest() {
        TowerOfHanoi th = new TowerOfHanoi();
        th.computeTowerHanoi(NUM_OF_DISKS);
    }
}
