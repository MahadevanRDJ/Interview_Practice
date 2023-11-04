package Practice.Test_3;

public class UpperTriangularSpiral {
    public static void main(String[] args) {
        UpperTriangularSpiral upperTriangularSpiral = new UpperTriangularSpiral();

        upperTriangularSpiral.form(5);
    }

    private void form(int n) {
        int[][] A = new int[n][n];
        int row = 0, column = 0;
        int l = (n * (n + 1)) / 2, k = 1;

        while (true) {

            // Diagonal
            while (row < n && column < n && A[row][column] == 0)
                A[row++][column++] = k++;
            if (k > l)
                break;
            row-=2;
            column--;

            // Up
            while (row >= 0 && A[row][column] == 0)
                A[row--][column] = k++;
            if (k > l)
                break;
            row++;column--;
            

            // Left
            while (column >= row && A[row][column] == 0)
                A[row][column--] = k++;
            if (k > l)
                break;
            row++;
            column += 2;
        }

        print(A);
    }

    private void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i > j)
                    System.out.print("\t");
                else
                    System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
