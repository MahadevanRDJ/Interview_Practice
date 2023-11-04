package Practice.Test_3;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();

        spiralMatrix.form(11);
    }

    private void form(int n) {
        int row = 0, column = 0, l = n * n, k = 1;
        int [][] A = new int[n][n];
        while(true) {

            while(column < n && A[row][column] == 0) A[row][column++] = k++;
            if(k > l) break;
            row++;column--;

            while(row < n && A[row][column] == 0) A[row++][column] = k++;
            if(k > l) break;
            row--;column--;

            while(column >= 0 && A[row][column] == 0) A[row][column--] = k++;
            if(k > l) break;
            row--;column++;

            while(row >= 0 && A[row][column] == 0) A[row--][column] = k++;
            if(k > l) break;
            row++;column++;

        }

        print(A);

    }

    public static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
