package October;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
    static int[] A = { 1, 3, 5, 6, 8, 9 };
    static int[] B = { 1, 3, 4, 6, 8, 8 };
    public static void main(String[] args) {
        IntersectionOfSortedArrays intersectionOfSortedArrays = new IntersectionOfSortedArrays();

        intersectionOfSortedArrays.intersect(A, B);
    }
    private void intersect(int[] a, int[] b) {
        brute(a, b);
        optimal(a, b);
    }
    private void optimal(int[] a, int[] b) {
        int i = 0, j = 0;
        List<Integer> intersect = new ArrayList<>();
        while(i < a.length) {
            if(a[i] == b[j]) 
                intersect.add(b[j++]);
            else if(a[i] > b[j]) j++;
            i++;
        }
        System.out.println(intersect);
    }

    private void brute(int[] a, int[] b) {
        var visited = new int[b.length];

        var intersect = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(b[j] > a[i]) break;
                if(a[i] == b[j] && visited[j] == 0) {
                    intersect.add(a[i]);
                    visited[j] = 1;
                    break;
                }
            }
        }
        System.out.println(intersect);
    }
}
