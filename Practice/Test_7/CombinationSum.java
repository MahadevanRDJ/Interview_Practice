package Practice.Test_7;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result;
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.find(7, 2, 3, 5, 7);
    }

    private void find(int target, int... a) {
        result = new ArrayList<>();
        bfs(a, target, 0, new ArrayList<Integer>());
        System.out.println(result);
    }

    private void bfs(int[] a, int target, int index, List<Integer> list) {
        if(target < 0) return;
        if(target == 0)  {
            result.add(List.copyOf(list));
            return;
        }

        for (int i = index; i < a.length; i++) {
            list.add(a[i]);
            bfs(a, target - a[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
