package September;

import java.util.LinkedList;
import java.util.Queue;

import Practice.Test_3.SpiralMatrix;

public class Matrix01 {
    byte[][] visited;
    int[][] distance;
    byte[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    public static void main(String[] args) {
        Matrix01 matrix01 = new Matrix01();
        int[][] A = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        matrix01.find(A);
    }

    private void find(int[][] a) {
        int m = a.length, n = a[0].length;

        visited = new byte[m][n];
        distance = new int[m][n];

        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    queue.add(new Coordinate(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Coordinate currCoordinate = queue.poll();

                for (int j = 0; j < directions.length; j++) {
                    int r = directions[j][0] + currCoordinate.row;
                    int c = directions[j][1] + currCoordinate.column;

                    if (r < 0 || r == m || c < 0 || c == n || visited[r][c] == 1)
                        continue;

                    visited[r][c] = 1;
                    distance[r][c] = count;
                    queue.add(new Coordinate(r, c));
                }
            }
            count++;
        }

        SpiralMatrix.print(distance);
    }
}
