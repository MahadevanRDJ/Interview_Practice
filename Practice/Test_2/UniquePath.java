package Practice.Test_2;

import java.util.Arrays;

public class UniquePath {
    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
       
        uniquePath.find(6, 6);
    }

    private void find(int rows, int columns) {
        int factor = 1;
        int[] row = new int[columns];
        if (rows < 3 && columns < 3)
            Arrays.fill(row, 1);
        else {
            for (int i = 0; i < columns; i++) 
                row[i] = columns - i;
            factor = 2;
        }

        for (int i = 0; i < rows - factor; i++) {
            for (int j = columns - 2; j >= 0; j--) 
                row[j] = row[j + 1] + row[j];
            System.out.println(Arrays.toString(row));
        }

        System.out.println(row[0]);
    }
}
