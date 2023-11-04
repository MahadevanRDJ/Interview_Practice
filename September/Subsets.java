package September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        
        System.out.println(subsets.subsets(1, 2, 3));
    }
    public List<List<Integer>> subsets(int... A) {

        find(A);
        // Arrays.sort(A);
        // bfs(A, 0, new ArrayList<>());    

        return result;
    }

    private void find(int[] a) {
        result.add(new ArrayList<>());
        
        for (int number : a) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(result.get(i));    
                list.add(number);
                result.add(list);
            }
            System.out.println(result);
        }
    }
    private void bfs(int[] A, int start, List<Integer> list) {
        
        if(result.contains(list)) return;
        result.add(new ArrayList<>(list));
        for(int i = start; i < A.length; i++) {
            list.add(A[i]);
            bfs(A, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
