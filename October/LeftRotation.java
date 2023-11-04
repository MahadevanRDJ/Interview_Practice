package October;

import java.util.Arrays;

public class LeftRotation {
    public static void main(String[] args) {
        LeftRotation leftRotation = new LeftRotation();
        leftRotation.rotate(3, 1, 2, 3, 4, 6, 8, 9);
    }

    private void rotate(int k, int... a) {
        
        brute(a, k);
        better(a, k);
        optimal(a, k);

    }

    private void brute(int[] a, int k) {
        k %= a.length;
        for (int i = 0; i < k; i++) {
            int first = a[0];

            for (int j = 1; j < a.length; j++) 
                a[j - 1] = a[j];
            a[a.length - 1] = first;
        }

        System.out.println(Arrays.toString(a));

    }

    private void optimal(int[] a, int k) {
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
        reverse(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


    private void reverse(int[] a, int left, int right) {
        while(left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++; 
            right--;
        }
    }

    private void better(int[] a, int k) {
        int [] temp = Arrays.copyOfRange(a, 0, k);

        for (int i = k; i < a.length; i++) {
            a[i - k] = a[i];
        }

        for (int i = 1; i <= temp.length; i++) {
            a[i + k] = temp[i - 1];
        }

        System.out.println(Arrays.toString(a));
    }
}
