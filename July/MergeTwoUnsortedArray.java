package July;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unused")
class MergeTwoUnsortedArray {
    private int[] A;
    private int[] B;

    public static void main(String[] args) {
        MergeTwoUnsortedArray mergeTwoUnsortedArray = new MergeTwoUnsortedArray();
        mergeTwoUnsortedArray.createArrays();
        mergeTwoUnsortedArray.mergeArray();

    }

    private void createArrays() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Size for two arrays");
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        A = new int[n];
        B = new int[m];
        System.out.println("A's Elements : ");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println("B's Elements : ");
        for (int i = 0; i < m; i++) {
            B[i] = scanner.nextInt();
        }
        scanner.close();
    }

    // Merge A and B array
    private void mergeArray() {
        int m = A.length + B.length;
        int temp[] = new int[m];
        for (int i = 0; i < A.length; i++) {
            temp[i] = A[i];
        }

        for (int i = A.length, j = 0; i < temp.length; j++,i++) {
            temp[i] = B[j];
        }
        mergeSort(temp);
        System.out.println(Arrays.toString(temp));
    }

    // Insertion sort
    private void insertionSort(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        } else {
            int temp = 0;
            for (int j = 1; j < arr.length; ++j) {
                temp = arr[j];
                int k = j - 1;
                while ((k >= 0 && temp < arr[k])) {
                    arr[k + 1] = arr[k];
                    --k;
                }
                ++k;
                arr[k] = temp;
            }
        }
    }

    //Merge Sort
    public void mergeSort(int arr[]) {
        mergeSort(arr, arr.length);
    }

    private void mergeSort(int[] arr, int n) {
        if(n > 1) {
            int x = n / 2, y = n - x;
            int[] X = new int[x];
            int[] Y = new int[y];

            for (int i = 0; i < n; i++) {
                if(i < x) X[i] = arr[i];
                else Y[i - x] = arr[i];
            }
            
            
            mergeSort(X, x);
            mergeSort(Y, y);
            int i = 0, j = 0, k = 0;
            while(i < x && j < y) {
                if(X[i] < Y[j]) arr[k++] = X[i++];
                else arr[k++] = Y[j++];
            }
            while(i < x) arr[k++] = X[i++];
            while(j < n - x) arr[k++] = Y[j++];
        }
    }
}