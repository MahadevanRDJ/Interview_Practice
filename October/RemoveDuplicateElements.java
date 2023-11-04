package October;

import java.util.Arrays;

public class RemoveDuplicateElements {
    public static void main(String[] args) {
        RemoveDuplicateElements removeDuplicateElements = new RemoveDuplicateElements();
        removeDuplicateElements.remove(1, 2, 2, 3, 3, 3, 6, 6, 7);
    }

    private void remove(int... a) {
        int left = 0, right = 1;
        while(right < a.length) {
            if(a[left] != a[right]) 
                a[++left] = a[right];
            right++;
        }
        System.out.println(Arrays.toString(a));
    }
}
