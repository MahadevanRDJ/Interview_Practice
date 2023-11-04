package August;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class DetonateMaximumBombs {
    public static void main(String[] args) {
        DetonateMaximumBombs detonateMaximumBombs = new DetonateMaximumBombs();

        int[][] A = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6, 4 } };
        System.out.println(detonateMaximumBombs.maximumDetonation(A));;

    }

    public int maximumDetonation(int[][] bombs) {
        int max = 0;
        // iterate through each bomb and keep track of max
        for (int i = 0; i < bombs.length; i++) {
            max = Math.max(max, dfs(bombs, i));
        }
        return max;
    }

    private int dfs(int[][] bombs, int i) {
        boolean [] visited = new boolean[bombs.length];
        return dfs(i, bombs, visited);
    }

    private int bfs(int[][] bombs, int index) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[bombs.length];

        seen[index] = true;
        queue.offer(index);

        int count = 1; // start from 1 since the first added bomb can detonate itself

        while (!queue.isEmpty()) {
            int currBomb = queue.poll();
            for (int j = 0; j < bombs.length; j++) { 
                // search for bombs to detonate
                if (!seen[j] && isInRange(bombs[currBomb], bombs[j])) {
                    seen[j] = true;
                    count++;
                    queue.offer(j);
                }
            }
        }

        return count;
    }
    
    private int dfs(int index, int[][] bombs, boolean[] seen) {
        int count = 1;
        seen[index] = true;

        for (int i = 0; i < bombs.length; i++) {
            if (!seen[i] && isInRange(bombs[index], bombs[i])) {
                count += dfs(i, bombs, seen);
            }
        }

        return count;
    }

    
    // use the distance between two points formula
    // then check if curr bomb radius is greater than the distance; meaning we can
    // detonate the second bombs
    private boolean isInRange(int[] point1, int[] point2) {
        long dx = point1[0] - point2[0], dy = point1[1] - point2[1], radius = point1[2];
        long distance = dx * dx + dy * dy;
        return distance <= radius * radius;
    }
}
