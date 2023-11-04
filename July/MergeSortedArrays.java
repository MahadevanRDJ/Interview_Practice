package July;
import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[] A = new int[] { 2, 2, 3};
        int[] B = new int[] { 1, 9, 11 };
        int n = 3, m = 3;

        A = mergeSortedArrays.expand(A, m);
        mergeSortedArrays.sort(A, n, B, m);

        System.out.println("Merged array: " + Arrays.toString(A)); // Output
    }

    private int[] expand(int[] a, int m) {
        int[] temp = new int[a.length + m];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        return temp;
    }

    private void sort(int[] A, int n, int[] B, int m) {
        int last = m + n - 1;

        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1])
                A[last--] = A[--m];
            else
                A[last--] = B[--n];
        }

        while (n > 0)
            A[last--] = B[--n];
    }
}
