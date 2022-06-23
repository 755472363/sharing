package com.hyk.arithmetic.top101;

/**
 * BM64 最小花费爬楼梯
 */
public class Solution_BM64_最小花费爬楼梯 {

    /**
     * 数组长度：1≤n≤10
     * 方法：动态规划（推荐使用）
     * 思路：
     * 题目同样考察斐波那契数列的动态规划实现，不同的是题目要求了最小的花费，因此我们将方案统计进行递推的时候只记录最小的开销方案即可。
     * <p>
     * 具体做法：
     * step 1：可以用一个数组记录每次爬到第i阶楼梯的最小花费，然后每增加一级台阶就转移一次状态，最终得到结果。
     * step 2：（初始状态） 因为可以直接从第0级或是第1级台阶开始，因此这两级的花费都直接为0.
     * step 3：（状态转移） 每次到一个台阶，只有两种情况，要么是它前一级台阶向上一步，要么是它前两级的台阶向上两步，
     * 因为在前面的台阶花费我们都得到了，因此每次更新最小值即可，转移方程为：dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])。
     */

    public int minCostClimbingStairs(int[] cost) {
        // dp[i]表示爬到第i阶楼梯需要的最小花费
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            // 每次选取最小的方案
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 90, 1, 1, 80, 1};
//        int[] cost = {1};

        int res1 = new Solution_BM64_最小花费爬楼梯().minCostClimbingStairs(cost);
        System.out.println("res1 = " + res1);

        int res2 = new Solution_BM64_最小花费爬楼梯().minCostClimbingStairs2(cost);
        System.out.println("res2 = " + res2);
    }

}



