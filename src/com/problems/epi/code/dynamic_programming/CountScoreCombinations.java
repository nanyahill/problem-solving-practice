package com.problems.epi.code.dynamic_programming;

import java.util.List;

class Result {
    int numOfSequences;

    public Result() {
    }

}

/**
 * Counting score combinations- order does not matter. That is, a score combination of 2,3,7 and 7,3,2 are the same
 * and shouldn't be counted as different score combinations.
 * Unlike counting the number of sequences, order matters. That is, a score combination of 2,3,7 and 7,3,2 are
 * different and should be counted as different score combinations
 */
public class CountScoreCombinations {

    public static int countScoreCombinations_BottomUp2D(List<Integer> plays, int score) {
        if (plays == null || plays.size() == 0) return 1;
        int[][] table = new int[plays.size() + 1][score + 1];
        initTable(table);
        for (int i = 1; i <= plays.size(); i++) {
            int play = plays.get(i); // minor optimization
            for (int j = 1; j <= score; j++) {
                //int play = plays.get(i);
                //if (j < play) continue;
                if(j >= play) {
                    table[i][j] = table[i][j - play] + table[i - 1][j];
                }
                else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        return table[plays.size()][score];
    }

    private static void initTable(int[][] table) {
        for(int i = 0; i < table.length; i++) {
            table[i][0] = 1;
        }
        for(int i = 0; i < table[0].length; i++) {
            table[0][i] = 1;
        }

    }

    // Time Complexity: O(sn) where s = size of plays list and n = score
    // Space complexity: O(n)
    public static int countScoreCombinations_BottomUp1D(List<Integer> plays, int score) {
        if (plays == null || plays.size() == 0) return 1;
        int[] scoreBoard = new int[score + 1];
        scoreBoard[0] = 1;
        for (int i = 0; i < plays.size(); i++) {
            int play = plays.get(i); // minor optimization
            for (int j = play; j <= score; j++) {
                //int play = plays.get(i);
                //if (j < play) continue;
                int withThisPlay = scoreBoard[j - play];
                int withoutThisPlay = scoreBoard[j];
                scoreBoard[j] = withoutThisPlay + withThisPlay;
            }
        }
        return scoreBoard[score];
    }

    private static void initTable_TopDown(int[][] table) {
        for (int i = 0; i < table.length; i++) table[i][0] = 1;
    }

    public static int countScoreCombinations_TopDown(int score, List<Integer> plays) {
        if (plays == null || plays.size() == 0) return 1;
        int[][] table = new int[plays.size()][score + 1];
        initTable_TopDown(table);
        return countScoreCombinations_TopDown(plays, plays.size() - 1, score, table); // moving from right to left in plays list
    }

    // j is the score, i is the playIdx
    private static int countScoreCombinations_TopDown(List<Integer> plays, int i, int j, int[][] table) {
        if (i < 0) return 0;
        if (j == 0) return 1;
        if (j < 0) return 0;
        // Note i + 1 is not used to recurse for the 'withthisPlay'
        int withthisPlay = countScoreCombinations_TopDown(plays, i, j - plays.get(i), table);
        int withoutPlay = countScoreCombinations_TopDown(plays, i - 1, j, table);
        table[i][j] = withoutPlay + withthisPlay;

        return table[i][j];

//        return countScoreCombinations_Recursive(plays, score - plays.get(playIndex), playIndex, table) // with play
//            + countScoreCombinations_Recursive(plays, score, playIndex - 1, table); // without play
    }

    private static void initTable_Recursive(int[][] table) {
        for (int i = 0; i < table.length; i++) table[i][0] = 1;
    }

    // Recurrence relation: count(s, i) = count(s, i - 1) + count(s - [i], i)
    // where count(s, i) is the count with a score s, and a play of i
    public static int countScoreCombinations_Recursive(List<Integer> plays, int score) {
        if (plays == null || plays.size() == 0) return 1;
        int[][] table = new int[plays.size()][score + 1];
        return countScoreCombinations_Recursive(plays, score, plays.size() - 1); // moving from right to left in plays list
    }

    private static int countScoreCombinations_Recursive(List<Integer> plays, int score, int playIndex) {
        if (playIndex < 0) return 0;
        if (score == 0) return 1;
        if (score < 0) return 0;
        return countScoreCombinations_Recursive(plays, score - plays.get(playIndex), playIndex) // with play
                + countScoreCombinations_Recursive(plays, score, playIndex - 1); // without play
    }

    /******************************* Counts all sequences, order matters  *******************************/
    /**
     * Sequence here means order matters- combination of plays for a score of 12 could be 2,2,2,3,3 OR 2,3,3,2,2
     * The two sequences are different
     */
    public static int countAllSequencesOfCombinations_Iterative(List<Integer> plays, int score) {
        if (plays == null || plays.size() == 0) return 1;
        int[] scoreBoard = new int[score + 1];
        scoreBoard[0] = 1;
        for (int i = 1; i <= score; i++) {
            for (int j = 0; j < plays.size(); j++) {
                int play = plays.get(j);
                if (i < play) continue;
                int withThisPlay = scoreBoard[i - play];
                int withoutThisPlay = scoreBoard[i];
                scoreBoard[i] = withoutThisPlay + withThisPlay;
            }
        }
        return scoreBoard[score];
    }

    public static int countAllSequencesOfCombinations_Recursive(List<Integer> plays, int score) {
        if (plays == null || plays.size() == 0) return 0;
        Result r = new Result();
        countAllSequencesOfCombinations_Recursive(plays, score, r);
        return r.numOfSequences;
    }

    // Using Backtracking
    private static void countAllSequencesOfCombinations_Recursive(List<Integer> plays, int score, Result r) {
        if (score == 0) {
            r.numOfSequences++;
            return;
        }
        if (score < 0) return;
        for (int i = 0; i < plays.size(); i++) {
            countAllSequencesOfCombinations_Recursive(plays, score - plays.get(i), r);
        }
    }

    // Not efficient because if there is a large number of elements in the input, n number of recursive calls will be made
    // Although you can use a for loop in this case;
    public static int countAllSequencesOfCombinations_Recursive2(List<Integer> plays, int score) {
        if (score == 0) return 1;
        if (score < 0) return 0;

        return countAllSequencesOfCombinations_Recursive2(plays, score - plays.get(0))
                + countAllSequencesOfCombinations_Recursive2(plays, score - plays.get(1))
                + countAllSequencesOfCombinations_Recursive2(plays, score - plays.get(2));
    }
}