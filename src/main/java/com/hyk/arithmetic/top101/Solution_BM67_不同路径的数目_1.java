package com.hyk.arithmetic.top101;

/**
 * BM67 不同路径的数目(一)
 */
public class Solution_BM67_不同路径的数目_1 {

    /**
     * 一个机器人在m×n大小的地图的左上角（起点）。
     * 机器人每次可以向下或向右移动。机器人要到达地图的右下角（终点）。
     * 可以有多少种不同的路径从起点走到终点？
     *
     * 备注：m和n小于等于100,并保证计算结果在int范围内
     * 数据范围：0<n,m≤100，保证计算结果在32位整型范围内
     * 要求：空间复杂度 O(nm)，时间复杂度 O(nm)
     *
     * 事例1：
     * 输入：2,1
     * 返回值：1
     *
     * 事例2：
     *  输入：2,2
     *  返回值：2
     */

    /**
     * 动画的解题思路很清晰。
     * dp[i][j] 表示从起点到我当前位置（i行j列）有多少条可行的路径
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * <p>
     * 当 i > 1 && j > 1 : dp[i] [j] = dp[i] [j-1] + dp[i-1] [j]
     * 当 i = 0：dp[0][j] = dp[0][j-1]   因为dp[0][1],dp[0][2],dp[0][3],...恒等于1，dp[0] [j] = 1;
     * 当 j = 0：dp[i][0] = dp[i-1][0]   因为dp[1][0],dp[2][0],dp[3][0],...恒等于1，dp[0] [j] = 1;
     */
    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示从起点到我当前位置（i行j列）有多少条可行的路径
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    // i==0时候,路径只有1种，全部复制为1
                    dp[0][j] = 1;
                    // 不continue;最后会报越界异常。
                    continue;
                }
                if (j == 0) {
                    // i==0时候,路径只有1种，全部复制为1
                    dp[i][0] = 1;
                    continue;
                }
                // 当 i > 1 && j > 1 :  dp[i][j] = dp[i][j-1] + dp[i-1][j]
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 返回到达终点的所有可行路径
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int s1 = 4;
        int s2 = 4;
        int res2 = new Solution_BM67_不同路径的数目_1().uniquePaths(s1, s2);
        System.out.println("res2 = " + res2);
    }

}



