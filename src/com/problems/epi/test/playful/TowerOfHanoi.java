package com.problems.epi.test.playful;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TowerOfHanoi {
    static final int NUM_OF_PEGS = 3;
    static List<Deque<Integer>> pegs = new ArrayList<>();
    public static void solveTowerHanoiProblem(int numOfDisks) {
        initPegs(pegs);
        moveDisksToSrcPeg(pegs, numOfDisks);
        solveTowerHanoiProblem(numOfDisks, 0, 1, 2, pegs);
    }

    private static void solveTowerHanoiProblem(int numOfDisks, int src, int dest, int aux, List<Deque<Integer>> pegs) {
        if(numOfDisks == 0) return;
        solveTowerHanoiProblem(numOfDisks - 1, src, aux, dest, pegs);
        System.out.println("From " + src + " to "+ dest);
        pegs.get(dest).add(pegs.get(src).removeLast());
        solveTowerHanoiProblem(numOfDisks - 1, aux, dest, src, pegs);
    }

    private static void initPegs(List<Deque<Integer>> pegs) {
        for(int i = 0; i < NUM_OF_PEGS; i++){
            pegs.add(new ArrayDeque<>());
        }
    }

    private static void moveDisksToSrcPeg(List<Deque<Integer>> pegs, int numOfDisks) {
        for(int i = numOfDisks; i >= 0; i--) {
            pegs.get(0).addLast(i);
        }
    }

    private static int partition(int[] nums, int left, int right, int pivot) {
        while(left <= right) {
            if(nums[left] > pivot) {
                swap(nums, left, right);
                right--;
            }
            else if(nums[right] < pivot) {
                swap(nums, right, left);
                left++;
            }
            else {
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        solveTowerHanoiProblem(2);
        //System.out.println(partition(new int[] {5,1,6,3,2,4}, 0, 5, 3));
        // 0 to 2; 0 to 1; 2 to 1

        // 0 to 2;

    }

}
