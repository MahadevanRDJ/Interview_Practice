package October;

public class SecondLargestElement {
    public static void main(String[] args) {
        SecondLargestElement secondLargestElement = new SecondLargestElement();
        secondLargestElement.find(1, 5, 3, 4, 8,8, 7, 3 );
    }

    private void find(int... a) {

        int largest = a[0], sLargest = -1;

        for (int i = 1; i < a.length; i++) {
            if(a[i] > largest) {
                sLargest = largest;
                largest = a[i];
            } else if(a[i] < largest && a[i] > sLargest) sLargest = a[i];
        }

        System.out.println(sLargest);

    }
}
