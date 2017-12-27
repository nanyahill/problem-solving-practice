package com.problems.epi.code.bit_manipulation;

/**
 * Created by Nanya on 11/13/17.
 */
public class PowerOfX {

    public static double powerOfXIterative(double x, int power) {
        double result = 1.0;
        if (power < 0) {
            power = -power;
            x = 1 / x;
        }
        while (power != 0) {
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }

    public static double powerOfXRecursive(double x, int power) {
        if (power == 0) {
            return 1;
        } else if (power % 2 == 0) {
            return powerOfXRecursive(x, power / 2) * powerOfXRecursive(x, power / 2);
        } else {
            return powerOfXRecursive(x, power / 2) * powerOfXRecursive(x, power / 2) * x;
        }
    }

    public static double powerOfXRecursiveToo(double x, int power) {
        if (power == 0) {
            return 1;
        }
        double temp = powerOfXRecursiveToo(x, power / 2);
        if (power % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }
}
