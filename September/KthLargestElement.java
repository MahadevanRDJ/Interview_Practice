package September;

import java.util.Arrays;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.find(6,1 ,2, 3, 4, 5, 6));
    }

    public int find( int k, int... nums) {
        heapify(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i < k; i++) {
            nums = Arrays.copyOfRange(nums, 1, nums.length);
            // System.out.println(Arrays.toString(nums));
            heapify(nums);
            System.out.println(Arrays.toString(nums) + "--->" + i);
        }
        return nums[0];
    }


    private void heapify(int[] a) {
        int lastParent = a.length / 2 - 1;

        for (int i = lastParent; i >= 0; i--)
            heapify(a, i);
    }

    private void heapify(int[] a, int index) {
        int largestIndex = index;
        int leftIndex = index * 2 + 1;
        if (leftIndex < a.length && a[leftIndex] > a[largestIndex])
            largestIndex = leftIndex;

        int rightIndex = index * 2 + 2;
        if (rightIndex < a.length && a[rightIndex] > a[largestIndex])
            largestIndex = rightIndex;

        if (largestIndex == index) 
            return;
        swap(a, largestIndex, index);
        heapify(a, largestIndex);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
