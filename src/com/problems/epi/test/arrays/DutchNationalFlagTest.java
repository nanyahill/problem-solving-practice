package com.problems.epi.test.arrays;

import com.problems.epi.code.arrays.DutchNationalFlag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class DutchNationalFlagTest {

    @Test
    public void dutchNationalFlagProblemTest() {
        char[] chars = {'K', 'R', 'A', 'T', 'E', 'L', 'E', 'P', 'U', 'I', 'M', 'Q', 'C', 'X', 'O', 'S'};
        char[] actual = DutchNationalFlag.dutchFlagPartition2(chars, 0);
        System.out.print(Arrays.toString(actual));

    }

    @Test
    public void dutchNationalFlag_GenericTest() {
        int[] nums = {7, 3, 2, 1, 6, 5, 4};
        int[] nums3 = {3, 2, 1, 5, 6, 4};
        //7, 3, 2, 1, 6, 5, 4 };
        //'K', 'R', 'A', 'T','E', 'L', 'E', 'P', 'U', 'I', 'M', 'Q', 'C', 'X', 'O', 'S'};
        DutchNationalFlag.dutchFlagPartition_Generic(nums3, 1);
        System.out.print(Arrays.toString(nums3));
    }

    private static List<DutchNationalFlag.Color> randArray(int len) {
        Random r = new Random();
        List<DutchNationalFlag.Color> ret = new ArrayList<>(len);
        for (int i = 0; i < len; ++i) {
            ret.add(DutchNationalFlag.Color.values()[r.nextInt(3)]);
        }
        return ret;
    }

    @Test
    public void dutchNationalFlag_WithColorsTest() {
        Random gen = new Random();

        List<DutchNationalFlag.Color> A = randArray(7); // generates a list of seven elements from the enum values
        int pivotIndex = gen.nextInt(3); // want to generate number between 0 and 2

        System.out.println(pivotIndex);
        System.out.println(A);
        DutchNationalFlag.dutchFlagPartition_WithColor(A, pivotIndex); //partitions around a specific color chosen at random
        System.out.println(A);

        int[] B = {1, 2};
        int i = 0, j = 0;
        while(B[i++] == 8) System.out.println(i + " i");
        System.out.print(i);
    }
}
