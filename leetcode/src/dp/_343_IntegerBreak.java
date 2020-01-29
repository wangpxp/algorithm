package dp;

import java.util.Arrays;

public class _343_IntegerBreak {
    int[] memo = new int[100];

    public int integerBreak(int n) {
/*
        Arrays.fill(memo, -1);
        //return integerBreakRe(n);
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                memo[i] = Math.max(Math.max(memo[i], j*(i - j)), j*memo[i - j]);
            }
        }
        return memo[n];
*/
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }

    public int integerBreakRe(int n) {
        if (n == 1) return 1;
        if (memo[n] != -1) return memo[n];
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(Math.max(res, i*(n - i)), i*integerBreakRe(n - i));
        }
        memo[n] =res;
        return res;
    }
}
