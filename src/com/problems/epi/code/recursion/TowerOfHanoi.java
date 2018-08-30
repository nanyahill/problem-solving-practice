package com.problems.epi.code.recursion;

import com.util.ListNode;

import java.util.*;

public class TowerOfHanoi {
    private static final int NUM_PEGS = 3;


    public static List<List<Integer>> computeTowerHanoi(int numOfDisks) {
        if(numOfDisks < 0) return null;
        List<Deque<Integer>> pegs = new ArrayList<>(); // pegs are stacks
        for(int i = 0; i < NUM_PEGS; i++)
            pegs.add(new ArrayDeque<Integer>());
        for(int i = numOfDisks; i > 0; i--)
            pegs.get(0).addFirst(i);
        List<List<Integer>> result = new ArrayList<>();
        computeTowerHanoi(numOfDisks, pegs, 0, 1, 2, result);
        return result;
    }

    private static void computeTowerHanoi(int disksToMove, List<Deque<Integer>> pegs, int src, int dest, int aux, List<List<Integer>> result) {
        if(disksToMove == 0) return;
        computeTowerHanoi(disksToMove - 1, pegs, src, aux, dest, result);
        pegs.get(dest).addFirst(pegs.get(src).removeFirst());
        result.add(Arrays.asList(src, dest));
        //System.out.print(src + ", " + dest);
        computeTowerHanoi(disksToMove - 1, pegs, aux, dest, src, result);
    }
}
