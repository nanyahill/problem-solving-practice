package com.problems.epi.test.dynamic_programming;

public class Scrap {

    public static int recurrence1(int n) {
        if(n == 0 || n == 1) return 2;
        return 2 * recurrence1(n) * recurrence1(n - 1);
    }

    public static int recurrence1Another(int n) {
        int sum = 0;
        if(n == 0 || n == 1) return 2;
        for(int i = 1; i < n; i++) sum += 2 * recurrence1Another(i) * recurrence1Another(i - 1);
        return sum;
    }

    public static int recurrence1Another2(int n) {
        int[] table = new int[n + 1];
        table[0] = table[1] = 2;
        return recurrence1Another2(n, table);
    }

    private static int recurrence1Another2(int n, int[] table) {
        if(n == 0 || n == 1) return 2;
        for(int i = 2; i <= n; i++) {
          //if(table[i] > 0) continue;
//            recurrence1Another2(i, table);
            table[i] = 2 * recurrence1Another2(i, table) * table[i - 1];
        }
        return table[n];
    }

    public static void main(String[] args) {
        //System.out.println(recurrence1(5));
        //System.out.println(recurrence1Another2(5));
        String s1 = "abc";
        System.out.print(s1.substring(0,1));

    }
}
