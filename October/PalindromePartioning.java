package October;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
    List<List<String>> result ;
    public static void main(String[] args) {
        PalindromePartioning palindromePartioning = new PalindromePartioning();
        palindromePartioning.form("aab");
    }

    private List<List<String>> form(String string) {
        result = new ArrayList<>();

        bfs(string, 0, new ArrayList<String>());

        System.out.println(result);
        return result;
    }

    private void bfs(String string, int index, List<String> list) {
        if(index == string.length()) {
            result.add(List.copyOf(list));
            return;
        }

        for (int i = index; i < string.length(); i++) {
            if(isPalindrome(string, index - 1, i + 1)) {
                list.add(string.substring(index, i + 1));
                bfs(string, index + 1, list);
                list.remove(list.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String string, int left, int right) {
        while(++left < --right) {
            if(string.charAt(left) != string.charAt(right)) return false;
        }
        return true;
    }
}
