package Graphikos;

public class Q3_LongestPalindrome {
    public static void main(String[] args) {
        Q3_LongestPalindrome longestPalindrome = new Q3_LongestPalindrome();

        longestPalindrome.find("babad");
    }

    private void find(String string) {
        brute(string);
    }

    private void brute(String string) {
        int start = 0, end = 0;

        int length = 0;
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j < string.length(); j++) {
                String sub = string.substring(i, j);

                if(isPalindrome(sub)) {
                    int subLength =  j - i + 1;
                    if(length < subLength) {
                        length = subLength;
                        end = j;
                        start= i;
                    }
                }
            }
        }
        System.out.println(string.substring(start, end));
    }

    private boolean isPalindrome(String sub) {
        int left = -1, right = sub.length();

        while(++left < --right) {
            if(sub.charAt(left) != sub.charAt(right)) return false;
        }
        return true;
    }
}
