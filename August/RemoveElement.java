package August;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] A = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement.remove(A, 2) + " : " + Arrays.toString(A));;
    }

    private int remove(int[] A, int element) {
        int count = 0;

        for (int i = 0; i < A.length; i++) 
            if(A[i] != element) A[count++] = A[i];
        
        return count;
    }
}
