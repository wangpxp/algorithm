package dp;

public class _121_BestTime {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int dp = 0;
        int res = 0;
        for (int price : prices) {
            dp = price - min;
            if (res < dp) res = dp;
            if (price < min) min = price;
        }
        return res;
    }
}
