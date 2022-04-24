package com.problems.epi.test.recursion;

import com.problems.epi.code.recursion.BalancedParensGeneration;
import com.problems.epi.code.recursion.TowerOfHanoi;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BalancedParensGenerationTest {

    @Test
    public void generateBalancedParenthesesTest() {
        List<String> result = BalancedParensGeneration.generateBalancedParentheses(3);
        for(String inner : result) {
            System.out.println(inner);

        }
    }
}
