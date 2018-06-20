package com.problems.epi.code.arrays;

public class SpiralOrdering {

    /**
     * This prints out the elements of a matrix in the spiral order
     * There are four main directions for each layer of the matrix
     * Work your way from the outer layer to the inner layer
     * T: Top direction; R: Right direction; B: Bottom direction; L: Left direction
     * After each direction, eliminate the traversed direction by incrementing the corresponding direction
     * dir = (dir + 1) % 4 because there are four direction which you want to traverse one after the other
     */
    public static int[] spiralOrderMatrix(int[][] A) {
        if (A == null || A.length == 0) return null;
        int rows = A.length, cols = A[0].length;
        int[] result = new int[rows * cols];
        // this is neither the starting or ending point of the directions
        // it is simply what row/col the direction is starting with.
        int T = 0, R = cols - 1, B = rows - 1, L = 0; // T = Top, R= Right, B = Bottom, L = Left
        int dir = 0, idx = 0;

        while (T <= B && L <= R) {
            if (dir == 0) { // moves from L to R
                for (int i = L; i <= R; i++)
                    result[idx++] = A[T][i];
                T++;
            } else if (dir == 1) { // moves from T to B
                for (int i = T; i <= B; i++)
                    result[idx++] = A[i][R];
                R--;
            } else if (dir == 2) { // moves from R to L
                for (int i = R; i >= L; i--)
                    result[idx++] = A[B][i];
                B--;
            } else { // moves from B to T
                for (int i = B; i >= T; i--) // >= because L moves from last row to the second row. Element in first row and first column has already been visited.
                    result[idx++] = A[i][L];
                L++;
            }
            dir = (dir + 1) % 4;
        }
        return result;
    }
}
