package com.problems.epi.code.greedy_algorithms;

import java.util.List;

public class GasUpProblem {

    // Time: O(n); Space: O(1)
    public static int findAmpleCity(List<Integer> cities, List<Integer> distance) {
        if(cities == null || distance == null) return -1;
        int minRemainingGas = Integer.MAX_VALUE;
        int ampleCity = -1;
        int remainingGas = 0;
        for(int i = 0; i < cities.size(); i++) {
            remainingGas += cities.get(i) - (distance.get(i)/20);
            if(remainingGas < minRemainingGas) {
                minRemainingGas = remainingGas;
                ampleCity = (i + 1) % cities.size();
            }
        }
        return ampleCity;
    }
}
