package July;
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] A = new int[][] { { 0, 0, 0, 0, 0, 0, 0}, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };

        UniquePathsII uniquePathsII = new UniquePathsII();

        System.out.println(uniquePathsII.find(A));
    }

    private int find(int[][] A) {
        int row = A.length, column = A[0].length;

        int dp[] = new int[column];
        dp[column - 1] = 1;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (A[i][j] == 1)
                    dp[j] = 0;
                else if (j < column - 1)
                    dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }
}
