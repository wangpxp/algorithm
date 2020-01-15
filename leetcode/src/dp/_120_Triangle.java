package dp;

import java.util.List;

public class _120_Triangle {
    int row;
    int[][] memo;
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new int[row][row];
        dp = new int[row + 1][row + 1];
        return calMinDp(triangle);
    }

    private int calMinDp(List<List<Integer>> triangle) {
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int cur = triangle.get(i).get(j);
                dp[i][j] = Math.min(cur + dp[i + 1][j], cur + dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    //记忆搜索
    private int calMinRm(List<List<Integer>> triangle, int i, int j) {
        int cur = triangle.get(i).get(j);
        if (i == row - 1) return cur;
        if (memo[i + 1][j] == 0) {
            memo[i + 1][j] = calMinRm(triangle, i + 1, j);
        }
        if (memo[i + 1][j + 1] == 0) {
            memo[i + 1][j + 1] = calMinRm(triangle, i + 1, j + 1);
        }
        return Math.min(cur + memo[i + 1][j], cur + memo[i + 1][j + 1]);
    }

    //递归
    private int calMinR(List<List<Integer>> triangle, int i, int j) {
        int cur = triangle.get(i).get(j);
        if (i == triangle.size() - 1) return cur;
        int left = calMinR(triangle, i + 1, j);
        int right = calMinR(triangle, i + 1, j + 1);
        return Math.min(cur + left, cur + right);
    }



}
