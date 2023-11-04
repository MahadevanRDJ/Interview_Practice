package August;


public class SearchInRotatedArray {
    public static void main(String[] args) {
        int [] A = {4, 5, 6, 7, 0, 1, 2};
    
        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        System.out.println(searchInRotatedArray.search(A, 0));   
    }

    public int search(int[] arr, int target) {
        int n = arr.length;
        return binarySearch(arr, n, target);
    }

    private int binarySearch(int[] nums, int length, int target) {
        int left = 0, right = length - 1, mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;
            // left sorted portion
            else if (nums[left] <= nums[mid]) {
                // move to right sorted portion if below condition satisfies
                if (target > nums[mid] || target < nums[left])
                    left = mid + 1;
                // else left sorted portion
                else
                    right = mid - 1;
            } else {
                // move to left sorted portion if below condition satisfies
                if (target < nums[mid] || target > nums[right])
                    right = mid - 1;
                // else right sorted portion
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
