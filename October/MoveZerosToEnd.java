package October;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        MoveZerosToEnd moveZerosToEnd = new MoveZerosToEnd();
        moveZerosToEnd.move(1, 0, 3, 4, 0, 7, 6, 0, 8, 0, 6, 0);
    }

    private void move(int... a) {
        var b = a.clone();
        brute(b);
        optimal(b);
    }

    private void optimal(int[] a) {
        int left = 0, right = -1;

        while (++right < a.length) {
            if (a[right] != 0) {
                swap(a, left, right);
                left++;
            }
        }

        System.out.println(Arrays.toString(a));
    }

    private void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    private void brute(int[] a) {
        var temp = new int[a.length];

        int index = 0;
        for (int i = 0; i < temp.length; i++) 
            if (a[i] != 0)
                temp[index++] = a[i]; 
        
        System.out.println(Arrays.toString(temp));
    }
}
