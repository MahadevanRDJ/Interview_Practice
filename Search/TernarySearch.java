package Search;

public class TernarySearch implements Search {

    @Override
    public int search(int[] a, int target) {
        return search(a, target, 0, a.length - 1);
    }

    private int search(int[] a, int target, int low, int high) {
        if (low > high)
            return -1;

        int partitionSize = (high + low) / 3;
        int mid1 = low + partitionSize;
        int mid2 = high - partitionSize;

        if (a[mid1] == target)
            return mid1;
        else if (a[mid2] == target)
            return mid2;

        else if (a[mid1] > target)
            return search(a, target, low, mid1 - 1);
        else if (a[mid2] < target)
            return search(a, target, mid2 + 1, high);

        return search(a, target, mid1 + 1, mid2 - 1);
    }

    public int searchIter(int[] a, int target) {

        int low = 0, high = a.length - 1;

        while (low < high) {
            int partitionSize = (high - low) / 3;
            int mid1 = low + partitionSize;
            int mid2 = high - partitionSize;

            if (a[mid1] == target)
                return mid1;
            else if (a[mid2] == target)
                return mid2;

            else if (a[mid1] > target)
                high =  mid1 - 1;
            else if (a[mid2] < target)
                low =  mid2 + 1;
            else low =  mid1 + 1; high = mid2 - 1;
        }
        return -1;
    }

}
