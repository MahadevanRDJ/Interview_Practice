package November;

import java.util.LinkedList;
import java.util.Queue;

import Practice.Test_3.SpiralMatrix;

public class MSPaint {

    int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public static void main(String[] args) {
        MSPaint msPaint = new MSPaint();
        int[][] screen = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 2, 2, 2, 2, 2, 0, 1, 0 },
                { 1, 1, 1, 2, 2, 2, 0, 1, 0 },
                { 1, 1, 1, 2, 2, 2, 2, 2, 0 },
                { 1, 1, 1, 1, 1, 1, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 1 },
        };

        msPaint.color(screen, 3, 4, 3);
    }

    private void color(int[][] screen, int x, int y, int newColor) {

        int R = screen.length, C = screen[0].length;

        var visited = new int[R][C];

        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(new Coordinate(x, y));
        visited[x][y] = 1;
        int target = screen[x][y];
        screen[x][y] = newColor;


        while(!queue.isEmpty()) {
            Coordinate currentPosition = queue.poll();

            for (int i = 0; i < directions.length; i++) {

                int r = directions[i][0] + currentPosition.row;
                int c = directions[i][1] + currentPosition.column;

                if(r == R || r < 0 || c == C || c < 0 || visited[r][c] == 1 || screen[r][c] != target)  continue;

                visited[r][c] = 1;
                screen[r][c] = newColor;

                queue.add(new Coordinate(r, c));                
            }
        }

        SpiralMatrix.print(screen);

    }
}

class Coordinate {
    int row, column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
