package dp;

public class _309_BestTimeIII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        final int K_MAX = 2;
        int[][][] dp = new int[n][K_MAX + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= K_MAX; k++) {
                if (i - 1 == -1) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][K_MAX][0];
    }

}

