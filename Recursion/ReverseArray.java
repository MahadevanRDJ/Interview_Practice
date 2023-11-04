package Recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();
        reverseArray.reverse(1, 2, 3, 4, 6, 7, 4);
    }

    private void reverse(int... a) {

        // reverse2P(a, 0, a.length - 1);
        reverse1P(a, 0);
        System.out.println(Arrays.toString(a));
    }

    private void reverse1P(int[] a, int i) {
        if(i >= a.length / 2) return;
        swap(a, i, a.length - 1 - i);
        reverse1P(a, i + 1);
    }

    private void reverse2P(int[] a, int i, int j) {
        if (i >= j)
            return;
        swap(a, i, j);
        reverse2P(a, i + 1, j - 1);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
