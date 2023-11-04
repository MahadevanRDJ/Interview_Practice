package September;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("unused")
public class SurroundedRegions {

    int ROWS, COLS;
    int[][] directions = { { 0, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();

        char[][] board = {
                { 'O', 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'O', 'X', 'O' },
                { 'X', 'O', 'X', 'O', 'X' },
                { 'O', 'X', 'O', 'O', 'O' },
                { 'X', 'X', 'O', 'X', 'O' } };

        print(board);
        surroundedRegions.capture(board);
        print(board);
    }

    private void capture(char[][] board) {

        ROWS = board.length;
        COLS = board[0].length;

        for (int i = 0; i < COLS; i++) {
            if (board[0][i] == 'O')
                bfs(board, 0, i);
            if (board[ROWS - 1][i] == 'O')
                bfs(board, ROWS - 1, i);
        }
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0] == 'O')
                bfs(board, i, 0);
            if (board[i][COLS - 1] == 'O')
                bfs(board, i, COLS - 1);
        }

        print(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        if (row < 0 || row == ROWS || col < 0 || col == COLS || board[row][col] != 'O')
            return;
        board[row][col] = 'T';

        dfs(board, row - 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
        dfs(board, row + 1, col);
    }

    private void bfs(char[][] board, int row, int col) {
        Queue<Coordinate> queue = new ArrayDeque<>();

        queue.add(new Coordinate(row, col));

        while (!queue.isEmpty()) {
            Coordinate currPos = queue.poll();

            for (int i = 0; i < directions.length; i++) {
                int r = currPos.row + directions[i][0];
                int c = currPos.column + directions[i][1];

                if (r < 0 || r == ROWS || c < 0 || c == COLS || board[r][c] != 'O')
                    continue;
                board[r][c] = 'T';
                queue.add(new Coordinate(r, c));
            }
        }

    }

    public static void print(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
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