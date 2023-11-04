package July;
import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] A = { 1, 2, 3, 4, 5, 6 };
        rotateArray.rotate(A, 2);
        rotateArray.rotateExtraSpace(A, 3);
        rotateArray.rotateReverse(A, 0);
        System.out.println(Arrays.toString(A));
    }

    private void rotateReverse(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void rotateExtraSpace(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] oldNums = nums.clone();
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = oldNums[i];
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int last = nums[n - 1];
            for (int j = n - 1; j > 0; j--) 
                nums[j] = nums[j - 1];
            nums[0] = last;
        }
    }
}
