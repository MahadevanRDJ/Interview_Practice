package Graphikos;

public class Q10_WalkThrough {
    int ROW, COL;
    int[][] visited;
    int count;
    public static void main(String[] args) {
        Q10_WalkThrough walkThrough = new Q10_WalkThrough();

        int[][] A = {{0, 0, 0},{0, 0, 0},{0, 0 , 0}};
        walkThrough.find(A);
    }

    private void find(int[][] A) {
        ROW = A.length; COL = A[0].length;
        visited = new int[ROW][COL];
        bfs(A, 0, 0);

        System.out.println(count);
    }

    private void bfs(int[][] A, int r, int c) {

        if(r < 0 || r == ROW || c < 0 || c == COL || A[r][c] == 1 || visited[r][c] == 1) return;

        if(r == ROW -1 && c == COL -1) {
            count++;
            return;
        }

        visited[r][c] = 1;
        bfs(A, r, c + 1);
        bfs(A, r + 1, c);
        visited[r][c] = 0;
    }
}
