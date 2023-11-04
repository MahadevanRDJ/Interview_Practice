package Graphikos;

import java.util.ArrayList;
import java.util.List;

public class Q6_MergeTwoSortedArrays {
    static int[] A = { 3, 3, 5, 7, 9 };
    static int[] B = { 2, 2, 4, 6, 8, 8};

    public static void main(String[] args) {

        Q6_MergeTwoSortedArrays mergeTwoSortedArrays = new Q6_MergeTwoSortedArrays();

        mergeTwoSortedArrays.mergeAndSort(A, B);
        mergeTwoSortedArrays.mergeAndSort1(A, B);

    }

    private void mergeAndSort1(int[] a, int[] b) {
        int x = 0, y = 0, m = a.length, n = b.length;
        List<Integer> list = new ArrayList<>();

        while (x < m && y < n) {
            if (a[x] < b[y]) {
                // while (x + 1 < m && a[x] == a[x + 1])
                if (list.size() == 0 || !list.contains(a[x]))
                    list.add(a[x]);
                x++;
            } else if (a[x] > b[y]) {
                // while (y + 1 < n && b[y] == b[y + 1])
                if (list.size() == 0 || !list.contains(b[y]))
                    list.add(b[y]);
                y++;
            } else
                y++;
        }

        while (x < m) {
            // while (x + 1 < m && a[x] == a[x + 1])
            if (list.size() == 0 || !list.contains(a[x]))
                list.add(a[x]);
            x++;
        }
        while (y < n) {
            // while (y + 1 < n && b[y] == b[y + 1])
            if (list.size() == 0 || !list.contains(b[y]))
                list.add(b[y]);
            y++;
        }

        System.out.println(list);
    }

    public void mergeAndSort(int[] a, int[] b) {
        int x = 0, y = 0, m = a.length, n = b.length;
        List<Integer> list = new ArrayList<>();

        while (x < m && y < n) {
            if (a[x] < b[y]) {
                while (x + 1 < m && a[x] == a[x + 1])
                    x++;
                list.add(a[x++]);
            } else if (a[x] > b[y]) {
                while (y + 1 < n && b[y] == b[y + 1])
                    y++;
                list.add(b[y++]);
            } else
                y++;
        }

        while (x < m) {
            while (x + 1 < m && a[x] == a[x + 1])
                x++;
            list.add(a[x++]);
        }
        while (y < n) {
            while (y + 1 < n && b[y] == b[y + 1])
                y++;
            list.add(b[y++]);
        }

        System.out.println(list);
    }
}
