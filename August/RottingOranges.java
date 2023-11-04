package August;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        int[][] A = { { 2, 1, 1 }, { 1, 1, 1 }, { 0, 1, 2 } };
        System.out.println(rottingOranges.findRottenTime(A));
        rottingOranges.solve(' ');
    
    }

    private void solve(char string) {
    }

    public int findRottenTime(int[][] grid) {
        Queue<Pair> queue = new LinkedList<Pair>();

        int rows = grid.length, columns = grid[0].length, fresh = 0, time = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                else if (grid[i][j] == 2)
                    queue.add(new Pair(i, j));
            }
        }

        int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        while (!queue.isEmpty() && fresh > 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Pair pair = queue.poll();
                for (int j = 0; j < directions.length; j++) {
                    int r = directions[j][0] + pair.row,
                        c = directions[j][1] + pair.column;
                    if ((r < 0 || r == rows) ||
                            (c < 0 || c == columns) ||
                            (grid[r][c] != 1))
                        continue;
                    grid[r][c] = 2;
                    queue.add(new Pair(r, c));
                    fresh--;
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}

class Pair {
    int row;
    int column;

    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
