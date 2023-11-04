package Practice.Test_5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

import Sort.MergeSort;

public class AlternateSort {
    public static void main(String[] args) {
        AlternateSort alternateSort = new AlternateSort();
        alternateSort.sort(1, 6, 7, 3, 5, 4, 8);
        alternateSort.optimized(1, 6, 7, 3, 5, 4, 8);
    }

    private void optimized(int... a) {
        for (int i = 1; i < a.length; i++) {
            if (i % 2 == 1 && a[i] > a[i - 1])
                swap(i -1, i, a);
            else if (i % 2 == 0 && a[i] < a[i - 1])
                swap(i - 1, i, a);
        }
        System.out.println(Arrays.toString(a));    
    }

    private void swap(int left, int right, int[] a) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    private void sort(int... a) {
        new MergeSort().sort(a);

        int temp[] = new int[a.length];
        int left = 0, even = 0, odd = 1, middle = a.length / 2;

        // for (int i = 0; i < temp.length && middle <= a.length; i++) {
        // if(i % 2 == 0) temp[i] = a[middle++];
        // else temp[i] = a[even++];
        // }

        while (left < middle && middle < a.length) {
            temp[even] = a[middle++];
            if (odd < a.length)
                temp[odd] = a[left++];
            even += 2;
            odd += 2;
        }

        System.out.println(Arrays.toString(temp));
    }
}
