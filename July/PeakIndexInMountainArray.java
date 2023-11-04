package July;
public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();

        int[] arr = { 3, 5, 3, 2, 0 };
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        if (arr[0] > arr[1])
            return 1;
        if (arr[n - 1] > arr[n - 2])
            return n - 1;

        return binarySearch(arr, n);
    }

    private int binarySearch(int[] nums, int length) {
        int low = 1, high = length - 2, mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else // mid - 1 < mid
                high = mid - 1;
        }
        return -1;
    }
}
