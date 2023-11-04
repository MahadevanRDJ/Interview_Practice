package Sort; 

public class SelectionSOrt implements Sort {

    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {

            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) 
                if(a[j] < a[minIndex]) minIndex = j;

            if(minIndex == i) return;
            this.swap(a, i, minIndex);
        }
    }
}
