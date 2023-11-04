package September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    List<List<String>> result = new ArrayList<>();
    Set<Integer> currentCol = new HashSet<>();
    Set<Integer> antiDiagonal = new HashSet<>();
    Set<Integer> diagonal = new HashSet<>();
    int N;

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.form(8);
    }

    private void form(int n) {
        List<char[]> board = new ArrayList<>();
        N = n;

        // currentCol = new int[N];
        // diagonal = new int[2 * N - 1];
        // antiDiagonal = new int[2 * N - 1];
        
        for (int i = 0; i < N; i++) {
            char[] cs = new char[N];
            Arrays.fill(cs, '.');
            board.add(cs);
        }

        bfs(board, 0, new ArrayList<String>());
        System.out.println(result);

        // for (List<String> cs : result) {
        //     for (String str : cs)
        //         System.out.println(str);

        //     System.out.println();
        // }
        System.out.println(result.size());
    }

    private void bfs(List<char[]> board, int row, List<String> list) {
        if (row == N) {
            result.add(List.copyOf(list));
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!currentCol.contains(col) && !diagonal.contains(row - col) && !antiDiagonal.contains(row + col)) {
                board.get(row)[col] = 'Q';
                currentCol.add(col);
                diagonal.add(row - col);
                antiDiagonal.add(row + col);
                list.add(String.valueOf(board.get(row)));
                bfs(board, row + 1, list);
                currentCol.remove(col);
                diagonal.remove(row - col);
                antiDiagonal.remove(row + col);
                list.remove(String.valueOf(board.get(row)));
                board.get(row)[col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, List<char[]> board) {
        // column
        if (isNotValidColumn(row, col, board))
            return false;

        // anti-diagonal
        if (isNotValidAntiDiagonal(row, col, board))
            return false;

        // diagonal
        if (isNotValidDiagonal(row, col, board))
            return false;

        return true;
    }

    private boolean isNotValidDiagonal(int row, int col, List<char[]> board) {
        while (row >= 0 && col >= 0)
            if (board.get(row--)[col--] == 'Q')
                return true;
        return false;
    }

    private boolean isNotValidAntiDiagonal(int row, int col, List<char[]> board) {
        while (row >= 0 && col < N)
            if (board.get(row--)[col++] == 'Q')
                return true;
        return false;
    }

    private boolean isNotValidColumn(int row, int col, List<char[]> board) {
        while (row >= 0)
            if (board.get(row--)[col] == 'Q')
                return true;
        return false;
    }
}
