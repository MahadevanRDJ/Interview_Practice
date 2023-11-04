package August;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        
        new LongestCommonSubsequence().longestCommonSubsequence("abcde", "cde");
        
        
    }
    
    public void longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        
        StringBuilder str = new StringBuilder();

        while(n > 0 && m > 0) {
            if(text1.charAt(n - 1) == text2.charAt(m - 1)) {
                str.append(text1.charAt(--n));
                m--;
            }
            else if(dp[n - 1][m] > dp[n][m -1]) {
                n--;
            }
            else m--;
        }

        System.out.println(str.reverse().toString());


    }
}