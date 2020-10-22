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
        solveHanoi(disks, pegs, 0, 1, 2, result);
        return result;
    }

    private static void solveHanoi(int remainingDisks, List<Deque<Integer>> pegs, int src, int dest, int aux, List<List<Integer>> result) {
        if (remainingDisks == 0) return;
        solveHanoi(remainingDisks - 1, pegs, src, aux, dest, result);
        pegs.get(dest).push(pegs.get(src).pop());
        result.add(Arrays.asList(src, dest));
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
