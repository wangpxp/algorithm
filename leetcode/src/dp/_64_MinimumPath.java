package dp;

public class _64_MinimumPath {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) dp[j] = grid[i][j];
                else if (i < m && j == n) dp[j] = grid[i][j] + dp[j];
                else if (i == m && j < n) dp[j] = grid[i][j] + dp[j + 1];
                else dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public int minPathSum2Array(int[][] grid) {
        //return minPathSumRe(grid, 0, 0);
        int[][] dp = new int[grid.length][grid[0].length];
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) dp[i][j] = grid[i][j];
                else if (i < m && j == n) dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if (i == m && j < n) dp[i][j] = grid[i][j] + dp[i][j + 1];
                else dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    private int minPathSumRe(int[][] grid, int i, int j) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        if (i > m || j > n) return Integer.MAX_VALUE;
        if (i == m || j == n) return  grid[i][j];
        else return grid[i][j] + Math.min(minPathSumRe(grid, i + 1, j), minPathSumRe(grid, i, j + 1));
    }
}
