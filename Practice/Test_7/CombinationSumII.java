package Practice.Test_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    List<List<Integer>> result;
    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();

        combinationSumII.find(9, 1, 3, 1, 5, 6, 7, 9);
    }

    private void find(int target, int... a) {
        result = new ArrayList<>();

        Arrays.sort(a);
        bfs(a, target, 0, new ArrayList<Integer>());
        System.out.println(result);
    }

    private void bfs(int[] a, int target, int index, List<Integer> list) {

        if(target < 0) return;

        if(target == 0) {
            result.add(List.copyOf(list));
            return;
        }

        for (int i = index; i < a.length; i++) {

            if(i > index && a[i] == a[i - 1]) continue;

            list.add(a[i]);
            bfs(a, target - a[i], i + 1, list);
            list.remove(list.size() - 1);
            
        }
    }
}
