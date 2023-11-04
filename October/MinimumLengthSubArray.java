package October;

public class MinimumLengthSubArray {
    public static void main(String[] args) {
        MinimumLengthSubArray minimumLengthSubArray = new MinimumLengthSubArray();
        minimumLengthSubArray.find(7, 4, 3, 2, 6, 1);
    }

    private void find(int target, int... a) {
        brute(a, target);
        optimal(a, target);
    }

    private void optimal(int[] a, int target) {
        int left = 0, right = -1, sum = 0, length = Integer.MAX_VALUE;
        int end = 0, start = 0;

        while(++right < a.length) {
            sum += a[right];
            while(sum > target) sum -= a[left++];
            if(sum == target) {
                int tempLength = right - left + 1;
                if(length > tempLength) {
                    length = tempLength;
                    start = left;
                    end = right;
                }
                sum -= a[left++];
            }
        }
        for (int i = start; i <= end; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private void brute(int[] a, int target) {
        int length = Integer.MAX_VALUE;
        int end = 0, start =0;
        for (int i = 0; i < a.length; i++) {
            int sum = a[i];
            for (int j = i + 1; j < a.length; j++) {
                sum += a[j];
                if(sum == target && length > j - i + 1) {
                    length = j- i+ 1;
                    end = j;
                    start = i;
                }
            }
        }
        for (int i = start; i <= end; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
