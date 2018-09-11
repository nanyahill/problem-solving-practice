package com.problems.epi.test.playful;

import java.util.*;

public class AirBnB_Question {

    /**
     * Leetcode #39- SubSet Sum with distinct elements
     * https://xkcd.com/287/
     * Notes:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     */

    private static class Appetizers {
        private String name;
        private double price;

        public Appetizers(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    public static List<List<String >> findSubsetSum(Appetizers[] input, double sum) {
        List<List<String >> result = new ArrayList<>();
        if (input == null) return result;
        findSubsetSum(input, 0, sum, new ArrayList<>(), result);
        return result;
    }

    private static void findSubsetSum(Appetizers[] input, int start, double sum, List<String> tmp, List<List<String>> result) {
        if (compare(sum) < 0) return;
        if (compare(sum) == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < input.length; i++) {
            tmp.add(input[i].name);
            findSubsetSum(input, i, sum - input[i].price, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }

    private static int compare(double a) {
        final double EPSILON = 0.0000001;
        //double diff = (a - EPSILON) / a;
        if (a < -EPSILON) return -1;
        else return a > EPSILON ? 1 : 0;
    }

    public static void main(String[] args) {
        String[] names = {"Mixed Fruit", "French Fries", "Side Salad", "Hot Wings", "Mozzarella Sticks", "Sampler Plate"};
        double[] prices = {2.15, 2.75, 3.35, 3.55, 4.20, 5.80};
        Appetizers[] menu = new Appetizers[names.length];
        for(int i = 0; i < names.length; i++) {
            menu[i] = new Appetizers(names[i], prices[i]);
        }
        List<List<String>> result = findSubsetSum(menu, 15.05);
        for (List<String > set : result) {
            System.out.print(Arrays.toString(set.toArray()));
            System.out.println();
        }
    }

}
