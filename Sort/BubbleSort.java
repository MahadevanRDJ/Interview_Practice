package Sort;

public class BubbleSort implements Sort{

    @Override
    public void sort(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if(a[j] < a[j - 1]) {
                    this.swap(a, j, j - 1);
                    isSorted = false;
                }
            }
            if(isSorted) return;
        }
    }
}
