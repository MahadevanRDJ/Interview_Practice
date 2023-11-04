package Practice.Test_1;

public class MinimumLengthSubArray {
    public static void main(String[] args) {
        MinimumLengthSubArray minimumLengthSubArray = new MinimumLengthSubArray();

        int []A = {2, 3, 1, 2, 4, 3};
        System.out.println(minimumLengthSubArray.find(A, 7));
    }

    private int find(int[] a, int target) {
        int left = 0, total = 0, length = a.length + 1, right = 0;
        

        while(right < a.length) {
            total += a[right];
            while(total >= target) {
                length = Math.min(length, right - left + 1);
                total -= a[left++];
            }
            right++;
        }
        
        return length > a.length ? -1: length;
    }
    
}
