package July;
public class MinimumLengthSubArray {
    public static void main(String[] args) {
        MinimumLengthSubArray minimumLengthSubArray = new MinimumLengthSubArray();
        int[] A = {1, 2, 4, 3, 6, 4};
        System.out.println(minimumLengthSubArray.find(A, 10));
    }

    private int find(int[] nums, int target) {
        int left = 0, total = 0, length = nums.length + 1;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];
            while (total == target) {
                length = Math.min(length, right - left + 1);
                total -= nums[left++];
            }
        }

        return (length > nums.length) ? 0 : length;
    }

    
}
