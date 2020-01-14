package dp;

import java.util.List;

public class _120_Triangle {
    int row;
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new int[row][row];
        return calMinRm(triangle, 0, 0);
    }

    private int calMinRm(List<List<Integer>> triangle, int i, int j) {
        int cur = triangle.get(i).get(j);
        if (i == triangle.size() - 1) return cur;
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

    //记忆搜索

}
