package Practice.Test_1;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] A = { 2, 2, 5, 0, 0, 0 };
        int[] B = { 1, 7, 11 };
        mergeSortedArray.merge(A, 3, B, 3);
        
        System.out.println(Arrays.toString(A));
    }

    private void merge(int[] A, int m, int[] B, int n) {
        int last = m + n - 1;

        while (m > 0 && n > 0)
            A[last--] = A[m - 1] > B[n - 1] ? A[--m] : B[--n];
        
        while (n > 0)
            A[last--] = B[--n];
    }
}
