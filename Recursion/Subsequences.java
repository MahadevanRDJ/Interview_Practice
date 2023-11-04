package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] A) {
        // find(A); 
        backtrack(A, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] a, int index, List<Integer> list) {

        if(index == a.length) {
            result.add(List.copyOf(list));
            return;
        }

        backtrack(a, index+1, list);
        
        list.add(a[index]);
        backtrack(a, index+1, list);
        list.remove(list.size() - 1);
    }
}