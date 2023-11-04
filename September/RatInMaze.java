package September;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    List<String> list = new ArrayList<>();
    int[][] directions = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 }};
    static int N;
    String movement = "DLRU";

    public static void main(String[] args) {
        RatInMaze ratInMaze = new RatInMaze();
        int A[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };

        N = A.length;
        ratInMaze.dfs(A);
        System.out.println(ratInMaze.list);
    }

    private void dfs(int[][] A) {
        int[][] visited = new int[N][N];
        StringBuilder str = new StringBuilder();
        dfs(A, visited, str, 0, 0);

    }

    private void dfs(int[][] A, int[][] visited, StringBuilder str, int row, int col) {
        if(row == N - 1 && col == N - 1) {
            list.add(str.toString());
            return;
        }

        for (int i = 0; i < directions.length; i++) {
            int r = row + directions[i][0];
            int c = col + directions[i][1];

            if(r < 0 || r == N || c < 0 || c == N || visited[r][c] == 1 || A[r][c] == 0) continue;
            
            visited[r][c] = 1;
            str.append(movement.charAt(i));
            dfs(A, visited, str, r, c);
            str.deleteCharAt(str.length() - 1);
            visited[r][c] = 0;
            
        }

    }
}
