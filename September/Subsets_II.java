package September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        Subsets_II subset = new Subsets_II();

        System.out.println(subset.form(1,2,2));;

    }

    private List<List<Integer>> form(int... a) {
        Arrays.sort(a);
        bfs(a, 0, new ArrayList<>());
        return result;        
    }

    private void bfs(int[] a, int index, List<Integer> list) {

        result.add(List.copyOf(list));
        for (int i = index; i < a.length; i++) {
            if(i > index && a[i] == a[i - 1]) continue;

            list.add(a[i]);
            bfs(a, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
