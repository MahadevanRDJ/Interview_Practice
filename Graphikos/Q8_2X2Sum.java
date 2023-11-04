package Graphikos;

import java.util.Arrays;

import Practice.Test_3.SpiralMatrix;

public class Q8_2X2Sum {
    public static void main(String[] args) {
        Q8_2X2Sum sum = new Q8_2X2Sum();

        int[][] A = { { 12, 34, 45, 67 }, { 34, 56, 24, 89 }, { 73, 28, 39, 97 } };
        System.out.println(Arrays.deepToString(A));
        sum.find(A);
    }

    private void find(int[][] A) {
        int sum = 0;
        int[][] matrix = new int[2][2];

        SpiralMatrix.print(A);
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A[0].length - 1; j++) {
                if(i + 1 > A.length || j + 1 > A[0].length) continue;
                int temp = A[i][j] + A[i + 1][j] + A[i][j + 1] + A[i +  1][j + 1];

                if (sum < temp) {
                    sum = temp;
                    matrix = new int[][] { { A[i][j], A[i + 1][j] }, { A[i][j + 1], A[i + 1][j + 1] } };
                }
            }
        }

        SpiralMatrix.print(matrix);
    }
}
