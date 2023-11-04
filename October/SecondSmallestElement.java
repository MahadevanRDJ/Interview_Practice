package October;

public class SecondSmallestElement {
    public static void main(String[] args) {
        SecondSmallestElement secondSmallestElement = new SecondSmallestElement();
        secondSmallestElement.find(1, 5, 6, 2, 2, 6, 8, 8, 5, 7);
    }

    private void find(int... a) {
        int smallest = a[0], sSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if(a[i] < smallest) {
                sSmallest = smallest;
                smallest= a[i];
            } else if(a[i] > smallest && a[i] < sSmallest) {
                sSmallest= a[i];
            }
        }
        System.out.println(sSmallest);
    }
}
