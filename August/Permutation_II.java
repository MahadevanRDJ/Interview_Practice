package August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class Permutation_II {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Set<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        Permutation_II permutation_II = new Permutation_II();
        permutation_II.find(1, 1, 3);
        // System.out.println(set);
        System.out.println(result);
    }

    private void find(int... a) {
        boolean[] visited = new boolean[a.length];
        Arrays.sort(a);
        optimizedPermute(a, visited, new ArrayList<>());
        // permute(a, visited, new ArrayList<>());
    }

    private void permute(int[] a, boolean[] visited, List<Integer> list) {
         if (a.length == list.size()) {
            set.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (!visited[i]) {
                list.add(a[i]);
                visited[i] = true;
                permute(a, visited, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private void optimizedPermute(int[] a, boolean[] visited, List<Integer> list) {

        if (a.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (!visited[i]) {
                if (i > 0 && a[i - 1] == a[i] && !visited[i - 1])
                    continue;
                list.add(a[i]);
                visited[i] = true;
                optimizedPermute(a, visited, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
