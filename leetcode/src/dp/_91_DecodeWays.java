package dp;

import java.util.Arrays;

public class _91_DecodeWays {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        int len = s.length();
        memo[len] = 1;
        if (s.charAt(len - 1) == '0') memo[len - 1] = 0;
        else memo[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') memo[i] = 0;
            else if ((s.charAt(i) - '0') * 10+ s.charAt(i + 1) - '0' <= 26) {
                memo[i] = memo[i + 1] + memo[i + 2];
            } else memo[i] = memo[i + 1];
        }

        return memo[0];
        //return numDecodingsRe(s, 0);
    }

    private int numDecodingsRe(String s, int start) {
        if (s.length() == start) return 1;
        if (s.charAt(start) == '0') return 0;

        if (memo[start] != -1) return memo[start];

        int res1 = numDecodingsRe(s, start + 1);
        int res2 = 0;
        if (s.length() > start + 1) {
            int num = (s.charAt(start) - '0') * 10 + s.charAt(start + 1) - '0';
            if (num <= 26) {
                res2 = numDecodingsRe(s, start + 2);
            }
        }
        memo[start] = res1 + res2;
        return res1 + res2;
    }
}
