package Practice.Test_6;

import java.util.Arrays;

public class IntervalReverse {
    public static void main(String[] args) {
        IntervalReverse intervalReverse = new IntervalReverse();
        intervalReverse.reverse(4, 9, 4, 2, 3, 6, 1, 8, 5, 4, 11, 23);
    }

    private void reverse(int k, int... a) {

        brute(a, k);
    }

    private void brute(int[] a, int k) {
        int n = a.length, i = 0, j = 0;
        for (; i < n; i += k) {
            j = ((i + k - 1) % n) ;
            reverse(i, j,  a);
        }
        if(i - k > j) reverse(i - k, n - 1, a); 
        System.out.println(Arrays.toString(a));
    }

    private void reverse(int start, int end, int[] a) {
        System.out.println(start + " " + end);
        while(start < end) {
            swap(start, end, a);
            start++;
            end--;
        }
    }

    private void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
