package October;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement largestElement = new KthLargestElement();
        largestElement.find(3, 6, 7, 4, 2, 1, 9, 9, 7);
    }

    private void find(int k, int... a) {
        brute(k, a);
        bruteInDetail(a, k);

    }

    private void bruteInDetail(int[] a, int k) {

        heapify(a);

        int largest = 0;
        for (int i = 1; i <= k; i++) {
            int[] array = Arrays.copyOfRange(a, i, a.length);
            heapify(array);
            largest = array[0];
        }

        System.out.println(largest);
    }

    private void heapify(int[] a) {
        int lastParentIndex = (a.length / 2) - 1;

        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(i, a);
        }
    }

    private void heapify(int index, int[] a) {
        int largestIndex = index;

        int leftChildIndex = (index * 2) + 1;

        if (leftChildIndex < a.length && a[leftChildIndex] > a[largestIndex])
            largestIndex = leftChildIndex;

        int rightChildIndex = (index * 2) + 2;
        if (rightChildIndex < a.length && a[rightChildIndex] > a[largestIndex])
            largestIndex = rightChildIndex;

        if (index == largestIndex)
            return;

        swap(a, largestIndex, index);
        heapify(largestIndex, a);

    }

    private void swap(int[] a, int largestIndex, int index) {
        int temp = a[index];
        a[index] = a[largestIndex];
        a[largestIndex] = temp;
    }

    private void brute(int k, int[] A) {
        Queue<Integer> queue = new PriorityQueue<>(
                (a, b) -> {
                    if (a > b)
                        return -1;
                    else if (b > a)
                        return 1;
                    else
                        return 0;
                });

        for (int num : A) 
            queue.offer(num);
    
        for (int i = 0; i < k; i++) 
            queue.poll();
        
        System.out.println(queue.peek());
    }
}
