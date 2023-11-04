package October;

import java.util.Arrays;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        LongestConsecutiveSubsequence lcs = new LongestConsecutiveSubsequence();
        lcs.find(1, 100, 102, 3, 2, 101, 4, 4, 5);
    }

    private void find(int... a) {
        brute(a);
    }

    private void brute(int[] a) {
        int length = 1, longest = 1;
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if(a[i] - a[i - 1] == 1) length++;
            else if(a[i] - a[i - 1] > 1) 
                length = 1;
            if(longest < length) longest = length; 
        }
        System.out.println(longest);
    }
}
