package Recursion;

import Practice.Test_3.SpiralMatrix;

public class Pattern01 {
    int [][] A;
    public static void main(String[] args) {
        Pattern01 pattern01 = new Pattern01();
        pattern01.form(5);
    }

    private void form(int n) {
        int m = n * 2 + 1;
        A = new int[m][m];
        // printPattern(0, m);
        printPatternRec(0,m);
        SpiralMatrix.print(A);
    }

    private void printPattern(int m, int n) {

        while(m < n) {
            for (int i = m; i < n; i++) {
                for (int j = m; j < n; j++) {
                    if(i == m || i == n - 1|| j == n - 1|| j == m) A[i][j] = 1;
                }
            }

            m += 2;
            n -= 2;
        }


    }

    private void printPatternRec(int m, int n) {
        if(m >= n) return;

        for (int i = m; i < n; i++) {
            for (int j = m; j < n; j++) {
                if(i == m || i == n - 1|| j == n - 1|| j == m) A[i][j] = 1;
            }
        }

        printPatternRec(m + 2, n - 2);
    }
}
