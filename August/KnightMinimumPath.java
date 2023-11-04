package August;

import java.util.LinkedList;
import java.util.Queue;

public class KnightMinimumPath {

    private static final int N = 4;
    private int[][] chessBoard;
    private static int[][] direction = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { 1, -2 },
            { -1, 2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };
    int[][] directions = {{ 0, 1 }, { 1, 0 } };
    int minPath = Integer.MAX_VALUE;

    public static void main(String[] args) {
        KnightMinimumPath knightMinimumPath = new KnightMinimumPath();

        int[] source = { 0, 0 };
        int[] destination = { 3, 3 };

        System.out.println(knightMinimumPath.bfs(source, destination));
        // knightMinimumPath.helper(source, destination);
        // System.out.println(knightMinimumPath.minPath);
    }

    private void helper(int[] source, int[] destination) {
        chessBoard = new int[N][N];
        chessBoard[source[0]][source[1]] = 1;
        dfs(source[0], source[1], destination, 0);

    }

    private void dfs(int row, int col, int[] destination, int count) {

        if (row == destination[0] || col == destination[1]) {
            System.out.println(count);
            minPath = Math.min(minPath, count);
            return;
        }

        for (int i = 0; i < directions.length; i++) {
            int r = row + direction[i][0];
            int c = col + direction[i][1];

            if (r < 0 || r >= N || c < 0 || c >= N || chessBoard[r][c] == 1)
                continue;

            chessBoard[r][c] = 1;
            dfs(r, c, destination, count + 1);
            chessBoard[r][c] = 0;
        }

    }

    private int bfs(int[] source, int[] destination) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(source[0], source[1]));

        chessBoard = new int[N][N];
        chessBoard[source[0]][source[1]] = 1;

        int count = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int j = 0; j < size; j++) {

                Coordinate currentPosition = queue.poll();

                for (int i = 0; i < direction.length; i++) {
                    int row = direction[i][0] + currentPosition.row;
                    int column = direction[i][1] + currentPosition.column;

                    if (row == destination[0] && column == destination[1])
                        return ++count;

                    if (row < 0 || row >= N ||
                            column < 0 || column >= N ||
                            chessBoard[row][column] == 1)
                        continue;

                    // chessBoard[row][column] = 1;
                    queue.offer(new Coordinate(row, column));
                    count++; 
                }
            }
        }
        return -1;
    }
}
