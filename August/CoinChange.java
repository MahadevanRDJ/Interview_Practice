package August;

import java.util.*;


public class CoinChange {
    private Set<Integer> set;
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int A[] = {1, 3, 4, 5}, target = 7;
        coinChange.findBFS(A, target);
    }

    private void findBFS(int[] a, int target) {
        set = new TreeSet<>();
        bfs(a, target, 0);
        System.out.println(set);
        Iterator<Integer> it = set.iterator();
        System.out.println(it.next());

    }

    private void findGreedy(int[] a, int target) {

        int count = 0, m = target;
        Arrays.sort(a);


        for (int i = a.length - 1; i >= 0; i--) {
            while (m != 0) {
                m -= a[i];
                if(m < 0) {
                    m += a[i];
                    break;
                }
                count++;
            }
        }
        System.out.print("Count: " + count +" ");
        
    }


    private void bfs(int[]A, int target, int count) {
        if(target < 0) {
            set.add(-1);
            return;
        }
        if(target == 0){
            set.add(count);
            return;
        }

        for (int i = A.length - 1; i >= 0; i--) {
            int result = target - A[i];
            if( result >= 0) { 
                count++;
                int []temp = Arrays.copyOf(A, A.length);
                bfs(temp, result, count); 
            }
        }
    }
}
