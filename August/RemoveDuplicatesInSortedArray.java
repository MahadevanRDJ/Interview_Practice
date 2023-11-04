package August;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray removeDuplicatesInSortedArray = new RemoveDuplicatesInSortedArray();

        int []A = {1, 2, 2, 3, 3, 4, 5, 5, 5};
        System.out.println(removeDuplicatesInSortedArray.removeDuplicates(A) + " : " + Arrays.toString(A));;
    }

    private int removeDuplicates(int[] A) {
        int count = 1;

        for (int i = 0; i < A.length -1; i++) {
            if(A[i] == A[i + 1]) continue;
            A[count++] = A[i + 1];
        }

        return count;
    }
}
