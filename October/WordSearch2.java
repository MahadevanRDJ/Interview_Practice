package October;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import October.Trie;

class Trie {
    public char value;
    public Map<Character, Trie> children = new HashMap<>();
    public boolean isEnd;

    public Trie() {}

    public Trie(char val) {
        this.value = val;
    }

    @Override
    public String toString() {
        return "value = " + this.value;
    }


    public void insert(String word) {
        Trie current = this;
        for (char c : word.toCharArray()) {
            if (current.children.get(c) == null) {
                current.children.put(c, new Trie(c));
            }
            current = current.children.get(c);
        }
        current.isEnd = true;
    }

}



public class WordSearch2 {
    int R, C;
    Trie trie = new Trie(' ');
    int[][] visited;
    List<String> result;

    public static void main(String[] args) {
        WordSearch2 wordSearch = new WordSearch2();
        char[][] board = {
                 {'o','a','b','n'},
               {'o','t','a','e'},
               {'a','h','k','r'},
               {'a','f','l','v'}
        };
        String[] words = { "oaa", "oa", "oan" };
        wordSearch.search(board, words);
    }

    private void search(char[][] board, String[] words) {
        R = board.length;
        C = board[0].length;

        visited = new int[R][C];
        result = new ArrayList<>();

        for (String string : words)
            trie.insert(string);

        traverse(trie, "");
    
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dfs(board, i, j, "", trie);
            }
        }
        System.out.println(result);
    }

    private void traverse(Trie root, String string) {


        if(root.isEnd) result.add(string);

        for (Trie ptr : root.children.values()) {
            traverse(ptr, string + ptr.value);   
        }
    }

    private void dfs(char[][] board, int r, int c, String string, Trie root) {
        if (r == R || r < 0 || c == C || c < 0 ||
                visited[r][c] == 1 ||
                root.children.get(board[r][c]) == null)
            return;

        visited[r][c] = 1;
        string += board[r][c];
        root = root.children.get(board[r][c]);

        if (root.isEnd) {
            result.add(string);
            return;
        }
        dfs(board, r + 1, c, string, root);
        dfs(board, r - 1, c, string, root);
        dfs(board, r, c + 1, string, root);
        dfs(board, r, c - 1, string, root);
        visited[r][c] = 0;

    }

}