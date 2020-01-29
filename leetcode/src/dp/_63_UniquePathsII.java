package dp;

public class _63_UniquePathsII {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) memo[i][j] = 0;
                else {
                    if (i == 0 && j == 0) memo[i][j] = 1;
                    else if (i == 0) memo[i][j] = memo[i][j - 1];
                    else if (j == 0) memo[i][j] = memo[i - 1][j];
                    else memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                }
            }
        }
        return memo[m - 1][n - 1];
        //return uniquePathsWithObstaclesRe(0, 0, obstacleGrid);
    }

    private int uniquePathsWithObstaclesRe(int i, int j, int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (i == m || j == n || obstacleGrid[i][j] != 0) return 0;
        if (i == m - 1 && j == n - 1 && obstacleGrid[i][j] == 0) return 1;
        if (memo[i][j] != 0) return memo[i][j];

        memo[i][j] = uniquePathsWithObstaclesRe(i + 1, j, obstacleGrid)
                + uniquePathsWithObstaclesRe(i, j + 1, obstacleGrid);
        return memo[i][j];
    }
}
