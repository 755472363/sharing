package com.hyk.arithmetic.top101;

/**
 * BM63 跳台阶
 */
public class Solution_BM63_跳台阶 {

    /**
     * 描述
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 数据范围：1 ≤ n ≤ 40
     */

    /**
     * 台阶数  方法数
     * 1        1
     * 2        2
     * 3        3
     * 4        5
     * 递归 题目分析，假设f[i]表示在第i个台阶上可能的方法数。
     * 逆向思维。如果我从第n个台阶进行下台阶，下一步有2中走法，一种走到第n-1个台阶，一种是走到第n-2个台阶。所以f[n] = f[n-1] + f[n-2].
     */
    int[] dp = new int[50];

    public int jumpFloor(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // i= 2时，fn_2 相当于f(0) = 1,（疑问？？？：为啥f[0]=1，其中f[2]=f[1]+f[0]，f[2]=2,f[1]=1,所以f[0]=1 ）
    public int jumpFloor2(int n) {
        int fn = 1, fn_1 = 1, fn_2 = 1;
        for (int i = 2; i <= n; i++) {
            fn = fn_1 + fn_2;
            fn_1 = fn_2;
            fn_2 = fn;
        }
        return fn;
    }

    /**
     * 台阶数  方法数
     * 1        1
     * 2        2
     * 3        3
     * 4        5
     * 5        8
     * 6        13
     */
    public static void main(String[] args) {

        int res1 = new Solution_BM63_跳台阶().jumpFloor(5);
        System.out.println("res1 = " + res1);

        int res2 = new Solution_BM63_跳台阶().jumpFloor2(5);
        System.out.println("res2 = " + res2);
    }

}



