package Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(1, 4, 7, 3, 2, 9, 6, 8);
    }

    private void mergeSort(int... a) {

        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private void sort(int[] a, int low, int high) {
        if(low >= high) return;
        int middle = (high + low) / 2;

        sort(a, low, middle);
        sort(a, middle + 1, high);

        int i = 0, j = 0, k = 0;

        while (i < middle && j < high) {
            if (a[i] < a[j])
                i++;
            else
                j++;
            swap(a, i, j);
        }

        // while(i < middle) {
        //     swap(a, i, j);
        //     i++;
        // }
        // while( j < high) {
        //     swap(a, i, j);
        //     j++;
        // }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
