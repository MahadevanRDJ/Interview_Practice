package Practice.Test_2;

public class UniquePathWithObstacles {
    public static void main(String[] args) {
        UniquePathWithObstacles uniquePathWithObstacles = new UniquePathWithObstacles();
        int[][] A = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
        uniquePathWithObstacles.find(A);
    }

    private void find(int[][] a) {
        int rows = a.length, columns = a[0].length;

        int[] dp = new int[columns];
        dp[columns - 1] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = columns - 1; j >= 0; j--) {
                if (a[i][j] == 1)
                    dp[j] = 0;
                else if (j < columns - 1)
                    dp[j] = dp[j] + dp[j + 1];
            }
        }
        System.out.println(dp[0]);
    }
}
