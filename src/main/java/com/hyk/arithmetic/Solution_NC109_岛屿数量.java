package com.hyk.arithmetic;

import java.util.Arrays;

/**
 * NC109 岛屿数量
 */
public class Solution_NC109_岛屿数量 {
    /**
     * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
     * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
     * 例如：
     * 输入
     * [
     * [1,1,0,0,0],
     * [0,1,0,1,1],
     * [0,0,0,1,1],
     * [0,0,0,0,0],
     * [0,0,1,1,1]
     * ]
     * 对应的输出为3
     * (注：存储的01数据其实是字符'0','1')
     *
     * 示例1
     * 输入：[[1,1,0,0,0],[0,1,0,1,1],[0,0,0,1,1],[0,0,0,0,0],[0,0,1,1,1]]
     * 返回值：3
     *
     * 示例2
     * 输入：[[0]]
     * 返回值：0
     *
     * 示例3
     * 输入：[[1,1],[1,1]]
     * 返回值：1
     */

    /**
     * 方法一：dfs（推荐使用）
     * 思路：
     * 矩阵中多处聚集着1，要想统计1聚集的堆数而不重复统计，那我们可以考虑每次找到一堆相邻的1，就将其全部改成0，
     * 而将所有相邻的1改成0的步骤又可以使用深度优先搜索（dfs）：当我们遇到矩阵的某个元素为1时，首先将其置为了0，
     * 然后查看与它相邻的上下左右四个方向，如果这四个方向任意相邻元素为1，则进入该元素，进入该元素之后我们发现又回到了刚刚的子问题，
     * 又是把这一片相邻区域的1全部置为0，因此可以用递归实现。
     * //后续四个方向遍历
     * if(i - 1 >= 0 && grid[i - 1][j] == '1')
     * dfs(grid, i - 1, j);
     * if(i + 1 < n && grid[i + 1][j] == '1')
     * dfs(grid, i + 1,j);
     * if(j - 1 >= 0 && grid[i][j - 1] == '1')
     * dfs(grid, i, j - 1);
     * if(j + 1 < m && grid[i][j + 1] == '1')
     * dfs(grid, i, j + 1);
     * <p>
     * 终止条件： 进入某个元素修改其值为0后，遍历四个方向发现周围都没有1，那就不用继续递归，返回即可，或者递归到矩阵边界也同样可以结束。
     * 返回值： 每一级的子问题就是把修改后的矩阵返回，因为其是函数引用，也不用管。
     * 本级任务： 对于每一级任务就是将该位置的元素置为0，然后查询与之相邻的四个方向，看看能不能进入子问题。
     * <p>
     * 具体做法：
     * step 1：优先判断空矩阵等情况。
     * step 2：从上到下从左到右遍历矩阵每一个位置的元素，如果该元素值为1，统计岛屿数量。
     * step 3：接着将该位置的1改为0，然后使用dfs判断四个方向是否为1，分别进入4个分支继续修改。
     */
    public int solve(char[][] grid) {
        if (grid == null) return 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                    out(grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(i - 1, j, grid);
        }
        if (i + 1 < n && grid[i + 1][j] == '1') {
            dfs(i + 1, j, grid);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(i, j - 1, grid);
        }
        if (j + 1 < m && grid[i][j + 1] == '1') {
            dfs(i, j + 1, grid);
        }
    }

    public static void main(String[] args) {
//        char[][] grid = {{'1', '1', '0', '0', '0'}, {'0', '1', '0', '1', '1'}, {'0', '0', '0', '1', '1'}, {'0', '0', '0', '0', '0'}, {'0', '0', '1', '1', '1'}};
        char[][] grid = {{'1', '1', '1'}, {'1', '1', '1'}};


        new Solution_NC109_岛屿数量().out(grid);
        int res = new Solution_NC109_岛屿数量().solve(grid);
        // 3
        System.out.println("res = " + res);
    }


    private void out(char[][] grid) {
        for (char[] chars : grid) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println();
    }

}



