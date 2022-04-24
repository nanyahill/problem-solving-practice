package com.problems.epi.test.greedy_algorithms;

import com.problems.epi.code.greedy_algorithms.GasUpProblem;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GasUpProblemTest {

    @Test
    public void findAmpleCityTest() {
        List<Integer> cities = Arrays.asList(1,2,3,4,5);
        List<Integer> distance = Arrays.asList(3,4,5,1,2);
        int actualAmpleCity = GasUpProblem.findAmpleCity(cities,distance);
        int expectedAmpleCity = 3;
        Assert.assertEquals(expectedAmpleCity,actualAmpleCity);
    }
}
