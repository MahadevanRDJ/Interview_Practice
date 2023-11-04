package Generics;

import java.util.Arrays;

public class Executor {
    public static void main(String[] args) {
        // Group<Integer> group = new Group<>();

        // List list = new List();
        // list.add(1);
        // list.add("bjskdf");
    
        // group.add(1);

        // System.out.println(group.get(0));

        int[] nums = {6, 8, 5, 3, 1};
        int k =1;
        MaxHeap heap = new MaxHeap(nums.length);
        for (int number : nums)
            heap.insert(number);
        // for (int i = 0; i < k - 1; i++)
        //     heap.remove();
        System.out.println(heap.peek());
    }
}
class MaxHeap{
    private int[] array;
    private int size;

    public MaxHeap() {
    }

    public MaxHeap(int size) {
        array = new int[size];
    }

    public void insert(int data) {
        if(isFull()) throw new IllegalStateException("Heap size is full");
        array[size++] = data;
        bubbleUp();
    }

    public int remove() {
        if(isEmpty()) {throw new IllegalStateException("Heap is empty");}
        int data = array[0];
        array[0] = array[--size];
        bubbleDown();
        return data;

    }

    private void bubbleDown() {
        int index = 0;
        while(index <= size && !isValidParent(index)) {
            int largeChildIndex = largeChildIndex(index);
            // System.out.println(index + " " + largeChildIndex);
            // System.out.println(this.toString());
            swap(index, largeChildIndex);
            index = largeChildIndex;
        }
    }

    private boolean isValidParent(int index) {
        if(!hasLeftChild(index)) return true;

        boolean isValid = array[index] >= leftChild(index);
        
        if(hasRightChild(index)) isValid &= array[index] >= rightChild(index);
        
        return isValid;
    }

    private int largeChildIndex(int index) {
        if(!hasLeftChild(index)) return index;
        if(!hasRightChild(index)) return leftIndex(index);
        return leftChild(index) > rightChild(index) ? leftIndex(index) : rightIndex(index);
    }
 
    private int leftChild(int index) {
        return array[leftIndex(index)];
    }
    private int rightChild(int index) {
        return array[rightIndex(index)];
    }
    private boolean hasLeftChild(int index) {
        return leftIndex(index) <= size;
    }
    private boolean hasRightChild(int index) {
        return rightIndex(index) <= size;
    }

    private int rightIndex(int index) {
        return (index * 2) + 1;
    }

    private int leftIndex(int index) {
        return (index * 2) + 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && array[index] > array[parentIndex(index)]) {
            int parentIndex = parentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void swap(int index, int parentIndex) {
        int temp = array[index];
        array[index] = array[parentIndex];
        array[parentIndex] = temp;
    }

    private int parentIndex(int index) {
        return (index - 1)/2;
    }


    public String toString() {
        return Arrays.toString(array);
    }


    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int peek() {
        if(isEmpty()) throw new IllegalStateException("Heap is empty");
        return array[0];
    }

}
