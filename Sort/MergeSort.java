package Sort;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        int n = array.length;
        // Base condition
        if (n < 2)
            return;
        // Divide the arrays into half.
        int middle = n / 2;

        int[] left = new int[middle];
        for (int i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[n - middle];
        for (int i = middle; i < n; i++)
            right[i - middle] = array[i];

        // Divide until array size to 1.
        sort(left);
        sort(right);

        // Sort and merge them
        merge(left, right, array);

    }

    private void merge(int[] left, int[] right, int[] array) {
        int i, j, k;
        i = j = k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                array[k++] = left[i++];
            else
                array[k++] = right[j++];
        }

        while (i < left.length)
            array[k++] = left[i++];
        while (j < right.length)
            array[k++] = right[j++];
    }

}
