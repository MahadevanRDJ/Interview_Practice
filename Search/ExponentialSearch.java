package Search;

class ExponentialSearch implements Search{

    @Override
    public int search(int[] a, int target) {
        int bound = 1;

        while(bound < a.length && a[bound] < target) {
            bound *= 2;
        }

        int low = bound / 2;
        int high = Math.min(bound, a.length);
        return binarySearch(a, target, low, high);
    }

    private int binarySearch(int[] a, int target, int low, int high) {
        while(low < high) {
            int middle = (high + low) / 2;

            if(a[middle] == target) return middle;
            else if(a[middle] > target) high = middle - 1;
            else low = middle + 1;
        }
        return -1;
    }
    
}
