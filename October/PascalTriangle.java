package October;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        pascalTriangle.findElement(5, 1);
        pascalTriangle.generateRow(15);
        pascalTriangle.generatePattern(10);
    }

    private void generatePattern(int n) {
        brutePattern(n);
        optimalPattern(n);
    }

    private void optimalPattern(int n) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            result.add(optimized(i));
        }

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private void brutePattern(int n) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add((int) findElement(i, j));
            }
            result.add(row);
        }
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private void generateRow(int row) {
        brute(row);
        optimized(row);
    }

    private List<Integer> optimized(int row) {
        List<Integer> list = new ArrayList<>();

        long ans = 1;
        list.add(1);
        for (int i = 0; i < row; i++) {
            ans = ans * (row - i);
            ans = ans / (i + 1);
            list.add((int) ans);
        }

        // System.out.println(list);
        return list;
    }

    private void brute(int row) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= row; i++) {
            int ans = (int) findElement(row, i);
            list.add(ans);
        }

        // System.out.println(list);
    }

    private long findElement(int n, int r) {
        long ans = 1;

        for (int i = 0; i < r; i++) {
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }

        return ans;
    }
}
