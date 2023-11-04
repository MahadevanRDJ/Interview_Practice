package Graphikos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q7_ProductSubArray {
    List<int[]> result = new ArrayList<>();
    public static void main(String[] args) {
        Q7_ProductSubArray productSubArray = new Q7_ProductSubArray();

        productSubArray.find(1000, 1, 2, 5, 10);
    }

    private void find(int product, int... a)  {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int left = i, right = n; 

            while(left < right) {
                int[] arr = Arrays.copyOfRange(a, left, right);
                long tempProduct = calculate(arr);
                if(tempProduct < product) result.add(arr);
                right--;
            }
        }

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
        
    }

    private long calculate(int[] arr) {
        long product = 1;
        for (int i : arr) product *= i;
        return product;
    } 
}
