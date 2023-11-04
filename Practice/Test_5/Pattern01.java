package Practice.Test_5;

import Practice.Test_3.SpiralMatrix;

public class Pattern01 {
    public static void main(String[] args) {
        Pattern01 pattern01 = new Pattern01();

        pattern01.form(5);
    }

    private void form(int n) {
        int a = 0, b = n * 2;

        int[][] A = new int[b + 1][b + 1];

        while (a < b) {
            for (int i = a; i <= b; i++)
                for (int j = a; j <= b; j++)
                    if (i == a || i == b || j == a || j == b)
                        A[i][j] = 1;

            a += 2;
            b -= 2;
        }
        SpiralMatrix.print(A);

    }
}
