package August;

import java.util.LinkedList;
import java.util.Queue;


public class NumberOfIslands {
    private int[][] visited;

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(numberOfIslands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length, columns = grid[0].length, islands = 0;

        visited = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    islands++;
                    bfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    public void bfs(char[][] grid, int row, int column) {
        int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(new Coordinate(row, column));
        visited[row][column] = 1;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            for (int i = 0; i < directions.length; i++) {
                int r = directions[i][0] + coordinate.row;
                int c = directions[i][1] + coordinate.column;

                if (r >= 0 && r < grid.length &&
                        c >= 0 && c < grid[0].length &&
                        grid[r][c] == '1' &&
                        visited[r][c] != 1) {
                    queue.add(new Coordinate(r, c));
                    visited[r][c] = 1;
                }
            }
        }
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