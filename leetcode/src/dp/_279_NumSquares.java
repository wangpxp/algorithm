package dp;

import java.util.Arrays;

public class _279_NumSquares {

    int[] memo;

    public int numSquares(int n) {
        if(n <= 0){return 0;}
        if(check1(n)){
            return 1;
        }else if(check2(n)){
            return 2;
        }else if(check3(n)){
            return 3;
        }else{
            return 4;
        }
    }
    public boolean check1(int n){
        int tem = (int)Math.sqrt(n);
        return tem*tem == n;
    }
    public boolean check2(int n){
        for(int i = 1 ; i * i < n ; i++){
            if(check1(n-i*i))
                return true;
        }
        return false;
    }
    public boolean check3(int n){
        for(int i = 1 ; i * i < n ; i++){
            if(check2(n-i*i)){
                return true;
            }
        }
        return false;
    }

 /*   public int numSquares(int n) {
        memo = new int[n + 1];
        for (int i = 0; i < n+1; i++)  memo[i]=i;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                memo[i] = Math.min(memo[i], memo[i-j*j] + 1);
            }
        }
        return memo[n];
        //return numSquaresRe(n);
    }
*/
    private int numSquaresRe(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != -1) return memo[n];

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            res = Math.min(numSquaresRe(n-i*i) + 1, res);
        }
        memo[n] = res;
        return res;
    }
}
