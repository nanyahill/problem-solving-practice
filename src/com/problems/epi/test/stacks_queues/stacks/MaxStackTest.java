package com.problems.epi.test.stacks_queues.stacks;

import com.problems.epi.code.stacks_queues.stacks.MaxStackSolution1;
import com.problems.epi.code.stacks_queues.stacks.MaxStackSolution2;
import org.junit.Assert;
import org.junit.Test;

public class MaxStackTest {

    @Test
    public void maxStackSolution1Test() {
        MaxStackSolution1.push(3);
        MaxStackSolution1.push(6);
        MaxStackSolution1.push(2);
        MaxStackSolution1.push(4);
        MaxStackSolution1.pop();
        int expectedPop = 2;
        int expectedMax = 6;
        Assert.assertEquals(expectedPop, MaxStackSolution1.pop());
        Assert.assertEquals(expectedMax, MaxStackSolution1.max());

    }

    @Test
    public void maxStackSolution2Test() {
        MaxStackSolution2.push(3);
        MaxStackSolution2.push(6);
        MaxStackSolution2.push(2);
        MaxStackSolution2.push(4);
        MaxStackSolution2.pop();
        int expectedPop = 2;
        int expectedMax = 6;
        Assert.assertEquals(expectedPop, MaxStackSolution2.pop());
        Assert.assertEquals(expectedMax, MaxStackSolution2.max());

    }
}
