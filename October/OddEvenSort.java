package October;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OddEvenSort {

    public static void main(String[] args) {
        OddEvenSort oddEvenSort = new OddEvenSort();
        oddEvenSort.sort(1, 4, 6, 3, 8, 9, 11, 19);
    }

    private void sort(int... a) {

        brute(a.clone());
        optimal(a.clone());
    }

    private void optimal(int[] a) {
        int n = a.length;
        int i = 0, j = 1;

        while (i < n) {
            for (int k = i + 2; k < n; k++) {
                if (isOddAndGreater(a, j, k))
                    swap(a, j, k);
                else if (isEvenAndLesser(a, i, k))
                    swap(a, i, k);
            }
            i += 2;
            j += 2;
        }

        System.out.println(Arrays.toString(a));

    }

    private boolean isEvenAndLesser(int[] a, int i, int index) {
        return (index & 1) == 0 && a[index] < a[i];
    }

    private void swap(int[] a, int j, int i) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean isOddAndGreater(int[] a, int j, int index) {
        return isOdd(index) && a[index] > a[j];
    }

    private void brute(int[] a) {
        List<Integer> odd = new ArrayList<Integer>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (isOdd(i))
                odd.add(a[i]);
            else
                even.add(a[i]);
        }

        Collections.sort(odd, (x, y) -> y.compareTo(x));
        Collections.sort(even);

        System.out.println(odd);
        System.out.println(even);

        var b = new int[a.length];

        int x = 0, y = 0;
        for (int i = 0; i < b.length; i++) {
            if (isOdd(i))
                b[i] = odd.get(x++);
            else
                b[i] = even.get(y++);
        }

        System.out.println(Arrays.toString(b));

    }

    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
