package com.problems.epi.code.recursion;

import com.util.ListNode;

import java.util.*;

public class TowerOfHanoi {
    public List<Deque<Integer>> pegs = new ArrayList<>();
    int numOfPegs = 3;
    int numOfDisks = 6;
    public List<List<Integer>> result = null;

    public TowerOfHanoi(int numOfPegs, int numOfDisks) {
        this.numOfDisks = numOfDisks;
        this.numOfPegs = numOfPegs;
        result = new ArrayList<>();
        initPegs();
    }
    private void initPegs() {
        for(int i = 0; i < numOfPegs; i++)
            pegs.add(new ArrayDeque<Integer>());
        Deque<Integer> src = pegs.get(0);
        for(int j = numOfDisks; j > 0; j--)
            src.push(j);
    }

    public void computeTowerOfHanoi(int numOfDisks, List<Deque<Integer>> pegs, int src, int dest, int spare) {
        if(numOfDisks == 0) return;
        computeTowerOfHanoi(numOfDisks - 1, pegs, src, spare, dest);
        pegs.get(dest).push(pegs.get(src).pop());
        //result.add(Arrays.asList(src, dest));
        System.out.println("From: "+src+ " To: "+dest);
        computeTowerOfHanoi(numOfDisks - 1, pegs, spare, dest, src);
    }

    public static List<List<Integer>> computeTowerHanoi(int numOfDisks) {
        if(numOfDisks < 0) return null;
        List<Deque<Integer>> pegs = new ArrayList<>();
        for(int i = 0; i < 3; i++)
            pegs.add(new ArrayDeque<Integer>());
        for(int i = numOfDisks; i > 0; i--)
            pegs.get(0).addFirst(i);
        List<List<Integer>> result = new ArrayList<>();
        computeTOH(numOfDisks, pegs, 0, 1, 2);
        return result;
    }

    private static void computeTOH(int disksToMove, List<Deque<Integer>> pegs, int src, int dest, int aux) {
        if(disksToMove == 0) return;
        computeTOH(disksToMove - 1, pegs, src, aux, dest);
        pegs.get(dest).addFirst(pegs.get(src).removeFirst());
       // result.add(Arrays.asList(src, dest));
        System.out.print(src + ", " + dest);
        System.out.println();
        computeTOH(disksToMove - 1, pegs, aux, dest, src);
    }
}
