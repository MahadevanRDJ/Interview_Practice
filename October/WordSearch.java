package October;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        String[] words = { "oath", "pea", "eat", "rain" };
        for (String string : words) {
            if(wordSearch.search(board, string)) System.out.println(string);
        }
    }

    private int ROW, COLUMN;
    private int[][] visited;
    private String string;

    private boolean search(char[][] board, String str) {
        string = str;
        ROW = board.length;
        COLUMN = board[0].length;
        visited = new int[ROW][COLUMN];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == string.charAt(0) && bfs(board, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, int r, int c, int index) {
        if (index == string.length())
            return true;
        if (r == ROW || r < 0 || c == COLUMN || c < 0 ||
                visited[r][c] == 1 ||
                board[r][c] != string.charAt(index))
            return false;

        visited[r][c] = 1;

        boolean result = bfs(board, r - 1, c, index + 1) ||
                bfs(board, r, c - 1, index + 1) ||
                bfs(board, r, c + 1, index + 1) ||
                bfs(board, r + 1, c, index + 1);
        visited[r][c] = 0;

        return result;
    }
}
