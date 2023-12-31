package Sort;

@FunctionalInterface
public interface Sort {
    /**
     * @param a
     * integer array
     * @return
     * Take an input array sort them in ascending order.
     */
    void sort(int [] a);

    default void swap(int []a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j]=temp;
    }
}
