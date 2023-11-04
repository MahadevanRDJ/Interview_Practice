package July;
import java.util.Arrays;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();

        System.out.println(uniquePaths.optimizedFind(3, 3));

    }


    private int findNumberOfUniquePaths(int row, int column) {
        int A[][] = new int[row][column];

        for (int i = 0; i < A.length; i++) {
            Arrays.fill(A[i], 1);
        }

        for (int i = A.length - 1; i > 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                A[i - 1][j] = A[i - 1][j + 1] + A[i][j];
            }
        }
        return A[0][0];
    }

    private int find(int row, int column) {
        int lastRow[] = new int[column];
        int newRow[] = new int[column];
        Arrays.fill(lastRow, 1);

        for (int i = 0; i < row - 1; i++) {
            Arrays.fill(newRow, 1);
            for (int j = column - 2; j >= 0; j--) {
                int right = newRow[j + 1], down = lastRow[j];
                newRow[j] = right + down;
            }
            lastRow = newRow.clone();
        }
        return lastRow[0];
    }

    private int optimizedFind(int row, int column) {
        int lastRow[] = new int[column];
        // int newRow[] = new int[column];
        int factor = 1;
        if (row > 2 && column > 2) {
            factor = 2;
            for (int i = column - 1; i >= 0; i--)
                lastRow[i] = column - i;
            // lastRow = IntStream.rangeClosed(1, 7).map(i -> column + 1 - i).toArray();
        } else
            Arrays.fill(lastRow, 1);

        for (int i = 0; i < row - factor; i++) {
            // Arrays.fill(newRow, 1);
            for (int j = column - 2; j >= 0; j--) 
                lastRow[j] = lastRow[j + 1] + lastRow[j];
            // lastRow = newRow.clone();
        }
        return lastRow[0];
    }
}
