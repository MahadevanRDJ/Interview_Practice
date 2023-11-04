package September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] visited;

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        combinationSumII.find(8, 1, 2, 6, 5, 1, 7, 10);
    }

    public List<List<Integer>> find(int target, int... candidates) {
        Arrays.sort(candidates);
        visited = new boolean[candidates.length];
        dfs(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] a, int target, int index, List<Integer> list) {
        if (target < 0)
            return;

        if (target == 0)
            result.add(List.copyOf(list));

        for (int i = index; i < a.length; i++) {
            if (a[i] <= target) {
                if (i > index && a[i] == a[i - 1])
                    continue;
                list.add(a[i]);
                dfs(a, target - a[i], i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
