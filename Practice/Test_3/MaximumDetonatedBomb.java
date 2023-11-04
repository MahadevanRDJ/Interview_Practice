package Practice.Test_3;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDetonatedBomb {
    public static void main(String[] args) {
        MaximumDetonatedBomb maximumDetonatedBomb = new MaximumDetonatedBomb();

        int[][] A = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6, 4 } };
        System.out.println(maximumDetonatedBomb.find(A));
    }

    private int find(int[][] a) {
        int max = 0;

        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, bfs(a, i));
        }

        return max;
    }

    private int bfs(int[][] a, int i) {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[a.length];

        queue.offer(i);
        visited[i] = true;

        int count = 1;

        while(!queue.isEmpty()) {
            int currentBomb = queue.poll();

            for (int j = 0; j < a.length; j++) {
                if(!visited[j] && isInRange(a[j], a[currentBomb])) {
                    queue.offer(j);
                    visited[j] = true;
                    count++;
                }
            }
        }
        
        return count;
    }

    private boolean isInRange(int[] position_1, int[] position_2) {
        int x = position_1[0] - position_2[0];
        int y = position_1[1] - position_2[1];
        int radius = position_2[2];

        return radius * radius >= x * x + y * y;
    }
}
