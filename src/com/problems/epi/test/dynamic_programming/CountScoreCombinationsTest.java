package com.problems.epi.test.dynamic_programming;

import com.problems.epi.code.dynamic_programming.CountScoreCombinations;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountScoreCombinationsTest {

    @Test
    public void countScoreCombinationsTest() {
        int score = 12;
        List<Integer> plays = Arrays.asList(2, 3, 7);
        int expected = 4;
        //int actual = CountScoreCombinations.countScoreCombinations(plays, score);
        int actual = CountScoreCombinations.countScoreCombinations_Recursive(plays, score);
        assert(expected == actual);
    }

    @Test
    public void countAllSequencesOfScoreCombinationsTest() {
        int score = 12;
        List<Integer> plays = Arrays.asList(2, 3, 7);
        int expected = 18;
        //int actual = CountScoreCombinations.countAllSequencesOfCombinations_Recursive(plays, score);
        //assert(expected == actual);
        System.out.print(CountScoreCombinations.countScoreCombinations_Recursive(plays, score));
    }
}
