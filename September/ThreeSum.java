package September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int A[] = {-1,0,1,2,-1,-4};


        ThreeSum threeSum = new ThreeSum();

        System.out.println(threeSum.threeSum(A));

    }

    public List<List<Integer>> threeSum(int[] A) {

        Arrays.sort(A);

        for(int i = 1; i < A.length; i++) {
            if(A[i - 1] != A[i] && A[i] <= 0) 
                twoSum(A, 0 - A[i - 1], i - 1);
            
        }    

        return result;
    }

    private void twoSum(int[] a, int target, int index) {
        int left = 0, right = a.length - 1;

        while(left < right) {
            int sum  =  a[left] + a[right];
            if(sum > target) right--;
            else if (sum < target) left++;
            else {
                result.add(List.of(a[index], a[left], a[right]));
                left++;
                right--;
            }
        }
    }
}
