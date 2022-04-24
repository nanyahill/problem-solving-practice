package com.problems.epi.code.greedy_algorithms;

import java.util.List;

/**
 * Understanding the problem arguments: cities is the gas available at each station,
 * distance is the cost to travel from the ith station to the i+1th station
 * Example: cities = [1,2,3,4,5] and distance = [3,4,5,1,2]
 * Then: my car can get filled with cities[0] amount of gas
 * which can enable me travel a distance[i] to i+1 city
 * Key Insight: In the problem, we are guaranteed that the amount of gas is enough to
 * go round all the cities once: A->B->C->D->E->A
 *
 */
public class GasUpProblem {

    // Time: O(n); Space: O(1)
    public static int findAmpleCity(List<Integer> cities, List<Integer> distance) {
        if(cities == null || distance == null) return -1;
        int minRemainingGas = Integer.MAX_VALUE;
        int ampleCity = -1;
        int remainingGas = 0;
        for(int i = 0; i < cities.size(); i++) {
            // Need to divide by 20 to run in EPIJudge
            //remainingGas += cities.get(i) - (distance.get(i)/20);
            remainingGas += cities.get(i) - (distance.get(i));
            if(remainingGas < minRemainingGas) {
                minRemainingGas = remainingGas;
                ampleCity = (i + 1) % cities.size();
            }
        }
        System.out.println(remainingGas);
        // This will return non-zero based index of the city. That is, ampleCity of 1 means the first city in array
        return ampleCity;
    }
}
