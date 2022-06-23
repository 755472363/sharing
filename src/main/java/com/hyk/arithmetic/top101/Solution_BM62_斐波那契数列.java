package com.hyk.arithmetic.top101;

/**
 * BM62 斐波那契数列
 */
public class Solution_BM62_斐波那契数列 {


    /**
     * fib(x)= 1   x=1,2
     * fib(x)= fib(x−1)+fib(x−2)  x>2
     */
    //方法一： 递归，很慢
    public int Fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //方法二： 递归，做缓存，不需要用map，用数组即可
    int[] dp = new int[50];

    public int Fibonacci2(int n) {
        if (n <= 2) return 1;
        if (dp[n] > 0) return dp[n];
        return dp[n] = Fibonacci2(n - 1) + Fibonacci2(n - 2);
    }

//    int[] dp3 = new int[50];

    //方法三： dp动态规划，类似于方法二（一个反向递推，一个正向递推）
    public int Fibonacci3(int n) {
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //方法四： dp动态规划
    public int Fibonacci4(int n) {
        if (n == 1 || n == 2) return 1;
        int i = 3;
        int fx = 0;
        int fx_1 = 1, fx_2 = 1;
        while (i <= n) {
            fx = fx_1 + fx_2;
            int temp = fx_1;
            fx_1 = fx;
            fx_2 = temp;
            i++;
        }
        return fx;
    }

    //方法五： dp动态规划（方法三，紧凑简化）
    public int Fibonacci5(int n) {
        int fx = 1;
        int fx_1 = 1, fx_2 = 1;
        for (int i = 3; i <= n; i++) {
            fx = fx_1 + fx_2;
            fx_1 = fx_2;
            fx_2 = fx;
        }
        return fx;
    }


    /**
     * 斐波那契数列
     * 索引：1 2 3 4 5 6 7  8
     * 数值：1 1 2 3 5 8 13 21
     */
    public static void main(String[] args) {
//        int res = new Solution_BM62_斐波那契数列().Fibonacci(7);
//        System.out.println("res = " + res);

        int res2 = new Solution_BM62_斐波那契数列().Fibonacci2(20);
        System.out.println("res2 = " + res2);

        int res3 = new Solution_BM62_斐波那契数列().Fibonacci3(20);
        System.out.println("res3 = " + res3);

        int res4 = new Solution_BM62_斐波那契数列().Fibonacci4(20);
        System.out.println("res4 = " + res4);

        int res5 = new Solution_BM62_斐波那契数列().Fibonacci5(20);
        System.out.println("res5 = " + res5);
    }

}



