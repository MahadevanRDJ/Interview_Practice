package October;

import java.util.Arrays;

public class RightRotation {
    public static void main(String[] args) {
        RightRotation rightRotation = new RightRotation();
        rightRotation.rotate(2, 1, 3, 5, 7, 8, 9);
    }

    private void rotate(int k, int... a) {
        brute(a, k);
        optimal(a, k);
    }

    private void optimal(int[] a, int k) {
        int n = a.length;
        k %= n;
        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
        System.out.println(Arrays.toString(a));
    }

    private void reverse(int[] a, int left, int right) {
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    private void brute(int[] a, int k) { 
        int n = a.length;
        k %= n;
        int [] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = a[i];
        }
        System.out.println(Arrays.toString(temp));
    }
}
