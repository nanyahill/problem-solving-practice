package com.problems.epi.test.stacks_queues.stacks;

import com.problems.epi.code.stacks_queues.stacks.EvaluateRPN;
import org.junit.Assert;
import org.junit.Test;

public class EvaluateRPNTest {

    @Test
    public void evaluateRPN_WithInputStringTest() {
        String input = "4,13,5,/,+";
        int expected = 6;
        int actual = EvaluateRPN.evaluateRPN_WithInputString(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void evaluateRPN_WithInputArrayTest() {
        String[] input = new String[] {"4","13","5","/","+"};
        int expected = 6;
        int actual = EvaluateRPN.evaluateRPN_WithInputArray(input);
        Assert.assertEquals(expected, actual);
    }
}
