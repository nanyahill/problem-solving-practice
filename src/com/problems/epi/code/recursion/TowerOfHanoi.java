package com.problems.epi.code.recursion;

import com.util.ListNode;

import java.util.*;

public class TowerOfHanoi {
    private static final int NUM_PEGS = 3;

    public static List<List<Integer>> computeTowerHanoi(int disks) {
        List<Deque<Integer>> pegs = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        initPegs(pegs, NUM_PEGS);
        addDisksToSrcPeg(pegs, disks);
        solveHanoi(disks, pegs, 0, 2,  1, result);
        return result;
    }

    /**
     * Move top n-1 disks to the auxiliary tower. (src is src, aux is dest, dest is aux)
     * Move 1 disk from source rod to destination rod. (src is src, aux is aux, dest is dest)
     * Move n-1 disks from auxiliary disk to the destination rod (src is aux, aux is src, dest is dest)
     * Total number of moves = 2^n - 1
     * Time complexity: O(2^n)
     * Good explanation: https://leetcode.com/discuss/interview-question/1392284/solving-tower-of-hanoi-using-the-magic-of-recursion
     * @param remainingDisks
     * @param pegs
     * @param src
     * @param dest
     * @param aux
     * @param result
     */

    private static void solveHanoi(int remainingDisks, List<Deque<Integer>> pegs, int src, int dest, int aux, List<List<Integer>> result) {
        if (remainingDisks == 0) return;
        solveHanoi(remainingDisks - 1, pegs, src, aux, dest, result);
        pegs.get(dest).push(pegs.get(src).pop());
        result.add(Arrays.asList(src + 1, dest + 1));
        solveHanoi(remainingDisks - 1, pegs, aux, dest, src, result);
    }

    private static void initPegs(List<Deque<Integer>> pegs, int numOfPegs) {
        for (int i = 0; i < numOfPegs; i++) {
            pegs.add(new ArrayDeque<>());
        }
    }

    private static void addDisksToSrcPeg(List<Deque<Integer>> pegs, int disks) {
        for (int i = disks; i >= 0; i--) {
            pegs.get(0).push(i);
        }
    }
}
