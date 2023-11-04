package September;

public class SecondLargest {
    public static void main(String[] args) {
        SecondLargest secondLargest = new SecondLargest();
        secondLargest.find(1, 2, 3, 4, 5, 6);
    }

    private void find(int... a) {
        boolean sorted = true;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if(a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                    sorted = false;
                }
            }
            if(sorted) break;
        }
        System.out.println(a[a.length - 2]);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}
