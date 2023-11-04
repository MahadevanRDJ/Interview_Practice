package Practice.Test_6;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();

        int[][] A = {
            { 2, 1, 0 },
            { 1, 0, 1 }, 
            { 0, 0, 1 } 
        };

        rottingOranges.find(A);
    }

    private void find(int[][] A) {

        int freshCount = 0;
        Queue<Coordinate> queue =new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 1) freshCount++;
                else if(A[i][j] == 2) queue.add(new Coordinate(i, j));
            }
        }

        bfs(queue, A, freshCount);
    }

    private void bfs(Queue<Coordinate> queue, int[][] A, int freshCount) {
        int row = A.length, column = A[0].length;

        while(!queue.isEmpty()) {
           Coordinate currentPosition = queue.poll();

           for (int i = 0; i < directions.length; i++) {
                int r = currentPosition.row + directions[i][0];
                int c = currentPosition.column+ directions[i][1];

                if(r < 0 || r == row || c < 0 || c == column || A[r][c] != 1) continue;
                
                A[r][c] = 2;
                queue.add(new Coordinate(r, c));
                freshCount--;
           }
        }

        System.out.println(freshCount);
    }
}

class Coordinate {
    int row;
    int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
