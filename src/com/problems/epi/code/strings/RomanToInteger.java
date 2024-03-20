package com.problems.epi.code.strings;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public class RomanToInteger {

    public static int romanToIntegerWithoutMap(String s) {
        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M':
                    number = 1000;
                    break;
                case 'D':
                    number = 500;
                    break;
                case 'C':
                    number = 100;
                    break;
                case 'L':
                    number = 50;
                    break;
                case 'X':
                    number = 10;
                    break;
                case 'V':
                    number = 5;
                    break;
                case 'I':
                    number = 1;
                    break;
            }
            if (number < prev) {
                answer -= number;
            } else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }

    public int romanToIntWithMap(String s) {
        if (s == null || s.isEmpty()) return -1;
        Map<Character, Integer> map = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i + 1) < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else sum += map.get(s.charAt(i));
        }
        return sum;
    }
}
