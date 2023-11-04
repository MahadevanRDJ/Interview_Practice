package Search;

class BinarySearch implements Search {

    @Override
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int searchRec(int[] nums, int target) {
        return searchRec(nums, target, 0, nums.length - 1);
    }

    private int searchRec(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;

        int middle = (low + high) / 2;

        if (nums[middle] == target)
            return middle;

        else if (nums[middle] > target)
            return searchRec(nums, target, low, middle - 1);

        return searchRec(nums, target, middle + 1, high);
    }
}
