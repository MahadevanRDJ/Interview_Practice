package August;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private static List<List<Integer>> result;
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.find(1, 1, 2);
        System.out.println(result);
        
    }

    

    private List<List<Integer>> find(int... a) {
        boolean []visited = new boolean[a.length];
        result = new ArrayList<>();
        // permute(a, visited, new ArrayList<>());
        optimizedPermute(a, 0);
        return new ArrayList<>(result);
    }

    private void optimizedPermute(int[] a, int index) {

        if (index == a.length) {
            List<Integer> list = new ArrayList<>();
            for (int number : a)
                list.add(number);
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = index; i < a.length; i++) {
            swap(i, index, a);
            optimizedPermute(a, index + 1);
            swap(i, index, a);
        }
    }



    private void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    private void permute(int[] a, boolean[] visited, List<Integer> list) {

        if(a.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if(!visited[i]) {
                list.add(a[i]);
                visited[i] = true;
                permute(a, visited, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
