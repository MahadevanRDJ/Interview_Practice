package October;

public class SudokuSolver {
    int size = 9;

    public static void main(String[] args) {
        char[][] board = {
                { '.', '8', '7', '6', '5', '4', '3', '2', '1' },
                { '2', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '3', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '4', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '5', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '6', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '7', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '8', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '9', '.', '.', '.', '.', '.', '.', '.', '.' },
        };

        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.generate(board);
        for (char[] cs : board) {
            System.out.println(cs);
        }

    }

    private boolean generate(char[][] board) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(i, j, board, k)) {
                            board[i][j] = k;
                            if (generate(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char[][] board, char k) {
        for (int i = 0; i < 9; i++) {
            if (isValidRow(row, board, k, i))
                return false;
            if (isValidColumn(col, board, k, i))
                return false;
            if (isValidBlock(row, col, board, k, i))
                return false;
        }
        return true;
    }

    private boolean isValidBlock(int row, int col, char[][] board, char k, int i) {
        return board[(((row / 3) * 3) + i / 3)][((col / 3) * 3) + i % 3] == k;
    }

    private boolean isValidColumn(int col, char[][] board, char k, int i) {
        return board[i][col] == k;
    }

    private boolean isValidRow(int row, char[][] board, char k, int i) {
        return board[row][i] == k;
    }
}
