package Practice.Test_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CoinChange {

    Map<Integer, List<Integer>> map;
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();

        coinChange.find(6249, 186, 419, 83, 408);
    }

    private void find(int target, int... a) {
        Arrays.sort(a);  
        map = new TreeMap<>();
        bfs(a, target, a.length - 1, new ArrayList<Integer>());   
        System.out.println(map);  
    }

    private void bfs(int[] a, int target, int index, List<Integer> list) {
        if(target == 0) {
            map.put(list.size(), List.copyOf(list));
            return;
        }

        for (int i = index; i >= 0; i--) {  
            if(target / a[i] < 1) continue;
            list.add(a[i]);
            bfs(a, target - a[i] , i, list);
            list.remove(list.size() - 1);
        }
    }
}
