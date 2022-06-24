package com.hyk.arithmetic.top101;

/**
 * BM68 矩阵的最小路径和
 */
public class Solution_BM68_矩阵的最小路径和 {

    /**
     * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
     * 数据范围: 1≤n,m≤500，矩阵中任意值都满足 0 ≤ aij ≤ 100
     * 要求：时间复杂度 O(nm)
     *
     * 例如：当输入[[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]]时，对应的返回值为12，
     * 所选择的最小累加和路径如下图所示：
     * [1,3,5,9]
     * [8,1,3,4]
     * [5,0,6,1]
     * [8,8,4,0]
     */

    /**
     * 方法：动态规划（推荐使用）
     * 思路：
     * 最朴素的解法莫过于枚举所有的路径，然后求和，找出其中最大值。但是像这种有状态值可以转移的问题，我们可以尝试用动态规划。
     * <p>
     * 具体做法：
     * step 1：我们可以构造一个与矩阵同样大小的二维辅助数组，其中dp[i][j]表示以(i,j)位置为终点的最短路径和，则dp[0][0]=matrix[0][0]。
     * step 2：很容易知道第一行与第一列，只能分别向右或向下，没有第二种选择，因此第一行只能由其左边的累加，第一列只能由其上面的累加。
     * step 3：边缘状态构造好以后，遍历矩阵，补全矩阵中每个位置的dp数组值：如果当前的位置是(i，j)，上一步要么是(i-1,j)往下，要么就是(i,j-1)往右，
     * 那么取其中较小值与当前位置的值相加就是到当前位置的最小路径和，因此状态转移公式为dp[i][j]=min(dp[i-1][j],dp[i][j-1])+matrix[i][j]。
     * step 4：最后移动到(n-1,m-1)的位置就是到右下角的最短路径和。
     * <p>
     * 当 i > 1 && j > 1 : dp[i][j] = min(dp[i-1][j],dp[i][j-1])+matrix[i][j]
     * 当 i = 0：dp[0][j] = dp[0][j-1] + matrix[0][j];
     * 当 j = 0：dp[i][0] = dp[i-1][0] + matrix[i][0];
     */
    public int minPathSum(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0)
                        dp[0][j] = matrix[0][0];
                    else
                        dp[0][j] = dp[0][j - 1] + matrix[0][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + matrix[i][0];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int res2 = new Solution_BM68_矩阵的最小路径和().minPathSum(matrix);
        System.out.println("res2 = " + res2);
    }

}



