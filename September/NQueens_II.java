package September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_II {
    int result;
    int[] currentCol;
    int[] antiDiagonal;
    int[] diagonal;
    int N;

    public static void main(String[] args) {
        NQueens_II nQueens = new NQueens_II();
        nQueens.form(8);
    }

    private void form(int n) {
        List<char[]> board = new ArrayList<>();
        N = n;

        currentCol = new int[N];
        diagonal = new int[2 * N - 1];
        antiDiagonal = new int[2 * N - 1];

        for (int i = 0; i < N; i++) {
            char[] cs = new char[N];
            Arrays.fill(cs, '.');
            board.add(cs);
        }

        bfs(board, 0);
        System.out.println(result);
    }

    private void bfs(List<char[]> board, int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (antiDiagonal[N - 1 + (row - col)] == 0
                    && currentCol[col] == 0 && diagonal[(row + col)] == 0) {
                board.get(row)[col] = 'Q';
                currentCol[col] = 1;
                diagonal[row + col] = 1;
                antiDiagonal[N - 1 + (row - col)] = 1;
                bfs(board, row + 1);
                currentCol[col] = 0;
                diagonal[row + col] = 0;
                antiDiagonal[N - 1 + (row - col)] = 0;
                board.get(row)[col] = '.';
            }
        }
    }

}
