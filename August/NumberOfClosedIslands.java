package August;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class NumberOfClosedIslands {
    private int[][] visited;
    private int rows, columns;

    public static void main(String[] args) {
        NumberOfClosedIslands numberOfClosedIslands = new NumberOfClosedIslands();
        int[][] grid = {
                { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 0 },
                { 1, 0, 1, 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0 }
        };
        System.out.println(numberOfClosedIslands.closedIsland(grid));
    }

    public int closedIsland(int[][] grid) {
        rows = grid.length;
        columns = grid[0].length;

        visited = new int[rows][columns];

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0)
                bfs(i, 0, grid);
            if (grid[i][columns - 1] == 0)
                bfs(i, columns - 1, grid);
        }

        for (int i = 0; i < grid.length; i++) {
            if (grid[0][i] == 0)
                bfs(0, i, grid);
            if (grid[rows - 1][i] == 0)
                bfs(rows - 1, i, grid);
        }

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                if (grid[i][j] == 0 && visited[i][j] != 1) {
                    // bfs(i, j, grid);
                    count+=dfs(j, count, grid);
                    // count++;
                }
            }
        }
        return count;
    }

    private void bfs(int r, int c, int[][] grid) {
        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(new Coordinate(r, c));

        visited[r][c] = 1;
        int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            for (int i = 0; i < directions.length; i++) {
                int row = coordinate.row + directions[i][0];
                int column = coordinate.column + directions[i][1];

                if (row < 0 || row == grid.length ||
                        column < 0 || column == grid[0].length ||
                        grid[row][column] != 0 || visited[row][column] == 1)
                    continue;

                queue.offer(new Coordinate(row, column));
                visited[row][column] = 1;
            }
        }
    }

    private int dfs(int r, int c, int[][] grid) {
        if (r < 0 || r == rows ||
                c < 0 || c == columns)
            return 0;
        if (grid[r][c] == 1 || visited[r][c] == 1)
            return 1;

        visited[r][c] = 1;
        return Math.min(
                Math.min(
                        dfs(r - 1, c, grid),
                        dfs(r, c - 1, grid)),
                Math.min(
                        dfs(r, c + 1, grid),
                        dfs(r + 1, c, grid))
        );
    }
}
