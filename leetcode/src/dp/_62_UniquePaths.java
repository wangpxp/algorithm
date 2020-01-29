package dp;

import java.util.Arrays;

public class _62_UniquePaths {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) memo[i][j] = 1;
                else if (i == m - 1) memo[i][j] = memo[i][j + 1];
                else if (j == n - 1) memo[i][j] = memo[i + 1][j];
                else memo[i][j] = memo[i + 1][j] + memo[i][j + 1];
            }
        }


        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        //return cur[n - 1];
        return memo[0][0];
        //return uniquePathsRe(m, n);
    }

    private int uniquePathsRe(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        if (memo[m][n] != 0) return memo[m][n];
        memo[m][n] = uniquePathsRe(m - 1, n) + uniquePathsRe(m, n - 1);
        return memo[m][n];
    }
}
